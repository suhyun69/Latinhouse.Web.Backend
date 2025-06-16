package com.latinhouse.backend.lesson.port.in;

import com.latinhouse.backend.lesson.port.in.response.LessonAppResponse;

import java.util.List;

public interface FindLessonUseCase {
    LessonAppResponse findById(String id);
    List<LessonAppResponse> findAll();
}
