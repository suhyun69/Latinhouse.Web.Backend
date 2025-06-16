package com.latinhouse.backend.lesson.port.in.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateLessonAppRequest {
    String id;
    String content;
}
