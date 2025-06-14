package com.latinhouse.backend.lesson.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Lesson {

    private final Long no;

    private final String title;
    private final Genre genre;

    private final String instructorLo;
    private final String instructorLa;

    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;

    private final List<String> dateTimeSubTexts;

    private final String region;
    private final String location;
    private final String locationUrl;

    private final BigDecimal price;
    private final BigDecimal maxDiscountAmount;
    private final List<String> discountSubTexts;

    private final String bankCode;
    private final String accountNumber;
    private final String accountOwner;

    private final List<String> notices;

    private final List<Discount> discounts;
    private final List<Contact> contacts;
}
