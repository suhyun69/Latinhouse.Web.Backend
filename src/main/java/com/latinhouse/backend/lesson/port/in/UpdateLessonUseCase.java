package com.latinhouse.backend.lesson.port.in;

import com.latinhouse.backend.lesson.port.in.request.UpdateLessonAppRequest;
import com.latinhouse.backend.lesson.port.in.response.LessonAppResponse;

public interface UpdateLessonUseCase {
    LessonAppResponse update(String id, UpdateLessonAppRequest appReq);
}
