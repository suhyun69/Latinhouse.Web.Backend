package com.latinhouse.backend.lesson.port.out;

import com.latinhouse.backend.lesson.domain.Lesson;
import com.latinhouse.backend.lesson.port.in.request.AddLessonAppRequest;

public interface CreateLessonPort {
    Lesson create(AddLessonAppRequest appReq);
}
