package com.latinhouse.backend.lesson.adapter.in.web.response;

import com.latinhouse.backend.lesson.port.in.response.LessonAppResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LessonWebResponse {
    private String id;
    private String content;

    public LessonWebResponse(LessonAppResponse appRes) {
        this.id = appRes.getId();
        this.content = appRes.getContent();
    }
}
