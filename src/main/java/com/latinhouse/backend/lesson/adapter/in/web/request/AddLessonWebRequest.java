package com.latinhouse.backend.lesson.adapter.in.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddLessonWebRequest {
    private String id;
    private String content;
}
