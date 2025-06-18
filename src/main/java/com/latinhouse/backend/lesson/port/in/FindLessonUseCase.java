package com.latinhouse.backend.lesson.port.in;

import com.latinhouse.backend.lesson.port.in.response.LessonAppResponse;

import java.util.List;
import java.util.Optional;

public interface FindLessonUseCase {
    Optional<LessonAppResponse> findById(String id);
    List<LessonAppResponse> findAll();
}
