package com.latinhouse.backend.lesson.adapter.out.persistence;

import com.latinhouse.backend.lesson.adapter.out.persistence.entity.LessonJpaEntity;
import com.latinhouse.backend.lesson.adapter.out.persistence.mapper.LessonMapper;
import com.latinhouse.backend.lesson.adapter.out.persistence.repository.LessonRepository;
import com.latinhouse.backend.lesson.domain.Lesson;
import com.latinhouse.backend.lesson.port.in.request.AddLessonAppRequest;
import com.latinhouse.backend.lesson.port.out.CreateLessonPort;
import com.latinhouse.backend.lesson.port.out.ReadLessonPort;
import com.latinhouse.backend.lesson.port.out.UpdateLessonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LessonPersistenceAdapter implements CreateLessonPort
        , ReadLessonPort
        , UpdateLessonPort
{

    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;

    @Override
    public Lesson create(AddLessonAppRequest appReq) {

        LessonJpaEntity lessonT = LessonJpaEntity.builder()
                .id(appReq.getId())
                .content(appReq.getContent())
                .build();

        return lessonMapper.mapToDomainEntity(lessonRepository.save(lessonT));
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll().stream()
                .map(lessonMapper::mapToDomainEntity)
                .toList();
    }

    @Override
    public Optional<Lesson> findById(String id) {
        return lessonRepository.findById(id)
                .map(lessonMapper::mapToDomainEntity);
    }

    @Override
    public Lesson update(Lesson lesson) {
        LessonJpaEntity lessonT = lessonMapper.mapToJpaEntity(lesson);
        LessonJpaEntity updated = lessonRepository.save(lessonT);
        return lessonMapper.mapToDomainEntity(updated);
    }
}
