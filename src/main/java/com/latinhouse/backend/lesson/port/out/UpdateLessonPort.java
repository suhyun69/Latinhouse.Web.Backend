package com.latinhouse.backend.lesson.port.out;

import com.latinhouse.backend.lesson.domain.Lesson;

public interface UpdateLessonPort {
    Lesson update(Lesson lesson);
}
