package com.latinhouse.backend.lesson.port.in.response;

import com.latinhouse.backend.lesson.domain.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LessonAppResponse {
    private String id;
    private String content;

    public LessonAppResponse(Lesson lesson) {
        this.id = lesson.getId();
        this.content = lesson.getContent();
    }
}
