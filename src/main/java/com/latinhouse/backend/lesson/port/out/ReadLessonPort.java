package com.latinhouse.backend.lesson.port.out;

import com.latinhouse.backend.lesson.domain.Lesson;

import java.util.List;
import java.util.Optional;

public interface ReadLessonPort {
    List<Lesson> findAll();
    Optional<Lesson> findById(String id);
}
