package com.latinhouse.backend.lesson.adapter.out.persistence.mapper;

import com.latinhouse.backend.lesson.adapter.out.persistence.entity.ContactJpaEntity;
import com.latinhouse.backend.lesson.adapter.out.persistence.entity.DiscountJpaEntity;
import com.latinhouse.backend.lesson.adapter.out.persistence.entity.LessonJpaEntity;
import com.latinhouse.backend.lesson.domain.Contact;
import com.latinhouse.backend.lesson.domain.Discount;
import com.latinhouse.backend.lesson.domain.Genre;
import com.latinhouse.backend.lesson.domain.Lesson;
import com.latinhouse.backend.lesson.port.in.request.AddLessonAppRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LessonMapper {

    public LessonJpaEntity mapToJpaEntity(Lesson lesson) {
        return LessonJpaEntity.builder()
                .no(lesson.getNo())
                .title(lesson.getTitle())
                .genre(lesson.getGenre().getCode())
                .instructorLo(lesson.getInstructorLo())
                .instructorLa(lesson.getInstructorLa())
                .startDateTime(lesson.getStartDateTime())
                .endDateTime(lesson.getEndDateTime())
                .dateTimeSubTexts(lesson.getDateTimeSubTexts())
                .region(lesson.getRegion())
                .location(lesson.getLocation())
                .locationUrl(lesson.getLocationUrl())
                .price(lesson.getPrice())
                .maxDiscountAmount(lesson.getMaxDiscountAmount())
                .discountSubTexts(lesson.getDiscountSubTexts())
                .bankCode(lesson.getBankCode())
                .accountNumber(lesson.getAccountNumber())
                .accountOwner(lesson.getAccountOwner())
                .notices(lesson.getNotices())
                .discounts(
                        Optional.ofNullable(lesson.getDiscounts())
                                .orElse(List.of())
                                .stream()
                                .map(d -> DiscountJpaEntity.builder()
                                        .id(d.getId())
                                        .type(d.getType())
                                        .condition(d.getCondition())
                                        .amount(d.getAmount())
                                        .build())
                                .collect(Collectors.toList())
                )
                .contacts(
                        Optional.ofNullable(lesson.getContacts())
                                .orElse(List.of())
                                .stream()
                                .map(c -> ContactJpaEntity.builder()
                                        .id(c.getId())
                                        .type(c.getType())
                                        .name(c.getName())
                                        .address(c.getAddress())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }

    public LessonJpaEntity mapToJpaEntity(AddLessonAppRequest appReq) {
        return LessonJpaEntity.builder()
                .title(appReq.getTitle())
                .genre(appReq.getGenre())
                .instructorLo(appReq.getInstructorLo())
                .instructorLa(appReq.getInstructorLa())
                .startDateTime(appReq.getStartDateTime())
                .endDateTime(appReq.getEndDateTime())
                .dateTimeSubTexts(appReq.getDateTimeSubTexts())
                .region(appReq.getRegion().getCode())
                .location(appReq.getLocation())
                .locationUrl(appReq.getLocationUrl())
                .price(appReq.getPrice())
                .maxDiscountAmount(appReq.getMaxDiscountAmount())
                .discountSubTexts(appReq.getDiscountSubTexts())
                .bankCode(appReq.getBankCode())
                .accountNumber(appReq.getAccountNumber())
                .accountOwner(appReq.getAccountOwner())
                .notices(appReq.getNotices())
                .discounts(
                        Optional.ofNullable(appReq.getDiscounts())
                                .orElse(List.of())
                                .stream()
                                .map(d -> DiscountJpaEntity.builder()
                                        .type(d.getType())
                                        .condition(d.getCondition())
                                        .amount(d.getAmount())
                                        .build())
                                .toList()
                )
                .contacts(
                        Optional.ofNullable(appReq.getContacts())
                                .orElse(List.of())
                                .stream()
                                .map(c -> ContactJpaEntity.builder()
                                        .type(c.getType())
                                        .name(c.getName())
                                        .address(c.getAddress())
                                        .build())
                                .toList()
                )
                .build();
    }

    public Lesson mapToDomainEntity(LessonJpaEntity entity) {
        return Lesson.builder()
                .no(entity.getNo())
                .title(entity.getTitle())
                .genre(Genre.of(entity.getGenre()))
                .instructorLo(entity.getInstructorLo())
                .instructorLa(entity.getInstructorLa())
                .startDateTime(entity.getStartDateTime())
                .endDateTime(entity.getEndDateTime())
                .dateTimeSubTexts(entity.getDateTimeSubTexts())
                .region(entity.getRegion())
                .location(entity.getLocation())
                .locationUrl(entity.getLocationUrl())
                .price(entity.getPrice())
                .maxDiscountAmount(entity.getMaxDiscountAmount())
                .discountSubTexts(entity.getDiscountSubTexts())
                .bankCode(entity.getBankCode())
                .accountNumber(entity.getAccountNumber())
                .accountOwner(entity.getAccountOwner())
                .notices(entity.getNotices())
                .discounts(
                        Optional.ofNullable(entity.getDiscounts())
                                .orElse(List.of())
                                .stream()
                                .map(d -> Discount.builder()
                                        .id(d.getId())
                                        .type(d.getType())
                                        .condition(d.getCondition())
                                        .amount(d.getAmount())
                                        .build())
                                .collect(Collectors.toList())
                )
                .contacts(
                        Optional.ofNullable(entity.getContacts())
                                .orElse(List.of())
                                .stream()
                                .map(c -> Contact.builder()
                                        .id(c.getId())
                                        .type(c.getType())
                                        .name(c.getName())
                                        .address(c.getAddress())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }
}
