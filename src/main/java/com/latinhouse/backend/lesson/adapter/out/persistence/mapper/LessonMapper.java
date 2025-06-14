package com.latinhouse.backend.lesson.adapter.out.persistence.mapper;

import com.latinhouse.backend.lesson.adapter.out.persistence.entity.LessonJpaEntity;
import com.latinhouse.backend.lesson.domain.Lesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonMapper {
    public LessonJpaEntity mapToJpaEntity(Lesson lesson) {
        return LessonJpaEntity.builder()
                .id(lesson.getId())
                .content(lesson.getContent())
                .build();
    }

    public Lesson mapToDomainEntity(LessonJpaEntity userT) {
        return Lesson.builder()
                .id(userT.getId())
                .content(userT.getContent())
                .build();
    }
}
