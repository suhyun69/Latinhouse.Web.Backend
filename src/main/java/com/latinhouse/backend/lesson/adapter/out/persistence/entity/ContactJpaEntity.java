package com.latinhouse.backend.lesson.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "lesson_contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String type;
    private String name;
    private String address;
}