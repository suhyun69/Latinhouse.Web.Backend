package com.latinhouse.backend.lesson.port.in;

import com.latinhouse.backend.lesson.port.in.request.AddLessonAppRequest;
import com.latinhouse.backend.lesson.port.in.response.LessonAppResponse;

public interface AddLessonUseCase {
    LessonAppResponse add(AddLessonAppRequest appReq);
}
