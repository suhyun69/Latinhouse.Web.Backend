package com.latinhouse.backend.lesson.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "lesson")
@Data
@Builder // mapToJpaEntity
@NoArgsConstructor
@AllArgsConstructor
public class LessonJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String title;
    private String genre;
    private String instructorLo;
    private String instructorLa;
    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @ElementCollection
    @CollectionTable(name = "lesson_datetime_subtext", joinColumns = @JoinColumn(name = "lesson_no"))
    @Column(name = "subtext")
    private List<String> dateTimeSubTexts;

    private String region;

    private String location;

    private String locationUrl;

    private BigDecimal price;

    private BigDecimal maxDiscountAmount;

    @ElementCollection
    @CollectionTable(name = "lesson_discount_subtext", joinColumns = @JoinColumn(name = "lesson_no"))
    @Column(name = "subtext")
    private List<String> discountSubTexts;

    private String bankCode;

    private String accountNumber;

    private String accountOwner;

    @ElementCollection
    @CollectionTable(name = "lesson_notice", joinColumns = @JoinColumn(name = "lesson_no"))
    @Column(name = "notice")
    private List<String> notices;

    // 추후 별도 테이블 매핑 필요 (if needed for filtering/searching)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lesson_no") // 외래키
    private List<DiscountJpaEntity> discounts;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lesson_no")
    private List<ContactJpaEntity> contacts;
}