package com.latinhouse.backend.lesson.application.service;

import com.latinhouse.backend.lesson.domain.Lesson;
import com.latinhouse.backend.lesson.port.in.AddLessonUseCase;
import com.latinhouse.backend.lesson.port.in.FindLessonUseCase;
import com.latinhouse.backend.lesson.port.in.UpdateLessonUseCase;
import com.latinhouse.backend.lesson.port.in.request.AddLessonAppRequest;
import com.latinhouse.backend.lesson.port.in.request.UpdateLessonAppRequest;
import com.latinhouse.backend.lesson.port.in.response.LessonAppResponse;
import com.latinhouse.backend.lesson.port.out.CreateLessonPort;
import com.latinhouse.backend.lesson.port.out.ReadLessonPort;
import com.latinhouse.backend.lesson.port.out.UpdateLessonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonService implements AddLessonUseCase
        , FindLessonUseCase
        , UpdateLessonUseCase
{

    private final CreateLessonPort createLessonPort;
    private final ReadLessonPort readLessonPort;
    private final UpdateLessonPort updateLessonPort;

    @Override
    public LessonAppResponse add(AddLessonAppRequest appReq) {
        return new LessonAppResponse(createLessonPort.create(appReq));
    }

    @Override
    public LessonAppResponse findById(String id) {
        return readLessonPort.findById(id)
                .map(LessonAppResponse::new)
                .orElse(null);
    }

    @Override
    public List<LessonAppResponse> findAll() {
        return readLessonPort.findAll().stream()
                .map(LessonAppResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public LessonAppResponse update(String id, UpdateLessonAppRequest appReq) {
        Optional<Lesson> optionalLesson = readLessonPort.findById(id);
        if (optionalLesson.isEmpty()) {
            throw new RuntimeException("Lesson not found");
        }

        Lesson lesson = optionalLesson.get();
        lesson.setContent(appReq.getContent());

        Lesson updated = updateLessonPort.update(lesson);
        return new LessonAppResponse(updated);
    }
}

