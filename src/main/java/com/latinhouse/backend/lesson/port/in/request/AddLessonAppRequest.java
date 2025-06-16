package com.latinhouse.backend.lesson.port.in.request;

import com.latinhouse.backend.lesson.adapter.in.web.request.AddLessonWebRequest;
import com.latinhouse.backend.lesson.domain.Genre;
import com.latinhouse.backend.profile.domain.Region;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Value
@Builder
public class AddLessonAppRequest {
    String title;
    String genre;
    String instructorLo;
    String instructorLa;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    List<String> dateTimeSubTexts;
    Region region;
    String location;
    String locationUrl;
    BigDecimal price;
    List<Discount> discounts;
    BigDecimal maxDiscountAmount;
    List<String> discountSubTexts;
    String bankCode;
    String accountNumber;
    String accountOwner;
    List<String> notices;
    List<Contact> contacts;

    @Value
    @Builder
    public static class Discount {
        String type; // Earlybird, Sex 구분 - enum 가능
        String condition;
        BigDecimal amount;
    }

    @Value
    @Builder
    public static class Contact {
        String type;   // P, K, I, Y, W - enum 가능
        String name;
        String address;
    }

    public static AddLessonAppRequest from(AddLessonWebRequest webReq) {

        LocalDateTime startDateTime = toDateTime(webReq.getStartDate(), webReq.getStartTime());
        LocalDateTime endDateTime = toDateTime(webReq.getEndDate(), webReq.getEndTime());

        // startDateTime vs endDateTime 검증
        if (!startDateTime.isBefore(endDateTime)) {
            throw new IllegalArgumentException("startDateTime must be before endDateTime.");
        }

        // instructorLo 또는 instructorLa 중 하나는 필수
        boolean noInstructorLo = webReq.getInstructorLo() == null || webReq.getInstructorLo().isBlank();
        boolean noInstructorLa = webReq.getInstructorLa() == null || webReq.getInstructorLa().isBlank();
        if (noInstructorLo && noInstructorLa) {
            throw new IllegalArgumentException("At least one of instructorLo or instructorLa must be provided.");
        }

        return AddLessonAppRequest.builder()
                .title(webReq.getTitle())
                .genre(webReq.getGenre())
                .instructorLo(webReq.getInstructorLo())
                .instructorLa(webReq.getInstructorLa())
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .dateTimeSubTexts(webReq.getDatetimeSubTexts())
                .region(Region.of(webReq.getRegion()))
                .location(webReq.getLocation())
                .locationUrl(webReq.getLocationUrl())
                .price(webReq.getPrice())
                .discounts(
                        Optional.ofNullable(webReq.getDiscounts())
                                .orElse(List.of())
                                .stream()
                                .map(d -> Discount.builder()
                                        .type(d.getType())
                                        .condition(d.getCondition())
                                        .amount(d.getAmount())
                                        .build())
                                .toList()
                )
                .maxDiscountAmount(webReq.getMaxDiscountAmount())
                .discountSubTexts(webReq.getDiscountSubTexts())
                .bankCode(webReq.getBankCode())
                .accountNumber(webReq.getAccountNumber())
                .accountOwner(webReq.getAccountOwner())
                .notices(webReq.getNotices())
                .contacts(
                        Optional.ofNullable(webReq.getContacts())
                                .orElse(List.of())
                                .stream()
                                .map(c -> Contact.builder()
                                        .type(c.getType())
                                        .name(c.getName())
                                        .address(c.getAddress())
                                        .build())
                                .toList()
                )
                .build();
    }

    public static LocalDateTime toDateTime(String startDate, String startTime) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalDate date = LocalDate.parse(startDate, dateFormatter);
            LocalTime time = LocalTime.parse(startTime, timeFormatter);

            return LocalDateTime.of(date, time);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date or time format. Expected 'yyyy-MM-dd' and 'HH:mm'.");
        }
    }
}
