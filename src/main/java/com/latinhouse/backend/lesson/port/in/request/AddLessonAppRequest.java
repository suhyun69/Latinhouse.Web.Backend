package com.latinhouse.backend.lesson.port.in.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddLessonAppRequest {
    String id;
    String content;
}
