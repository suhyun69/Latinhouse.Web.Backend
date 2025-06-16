package com.latinhouse.backend.lesson.adapter.in.web.response;

import com.latinhouse.backend.lesson.port.in.response.LessonAppResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class LessonWebResponse {

    private Long no;

    private String title;
    private String genre;

    private String instructorLo;
    private String instructorLa;

    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private List<String> dateTimeSubTexts;

    private String region;
    private String location;
    private String locationUrl;

    private BigDecimal price;
    private BigDecimal maxDiscountAmount;
    private List<String> discountSubTexts;

    private String bankCode;
    private String accountNumber;
    private String accountOwner;

    private List<String> notices;

    private List<DiscountResponse> discounts;
    private List<ContactResponse> contacts;

    public LessonWebResponse(LessonAppResponse appRes) {
        this.no = appRes.getNo();
        this.title = appRes.getTitle();
        this.genre = appRes.getGenre();
        this.instructorLo = appRes.getInstructorLo();
        this.instructorLa = appRes.getInstructorLa();
        this.startDate = extractDate(appRes.getStartDateTime());
        this.startTime = extractTime(appRes.getStartDateTime());
        this.endDate = extractDate(appRes.getEndDateTime());
        this.endTime = extractTime(appRes.getEndDateTime());
        this.dateTimeSubTexts = appRes.getDateTimeSubTexts();
        this.region = appRes.getRegion();
        this.location = appRes.getLocation();
        this.locationUrl = appRes.getLocationUrl();
        this.price = appRes.getPrice();
        this.maxDiscountAmount = appRes.getMaxDiscountAmount();
        this.discountSubTexts = appRes.getDiscountSubTexts();
        this.bankCode = appRes.getBankCode();
        this.accountNumber = appRes.getAccountNumber();
        this.accountOwner = appRes.getAccountOwner();
        this.notices = appRes.getNotices();
        this.discounts = appRes.getDiscounts().stream().map(DiscountResponse::from).toList();
        this.contacts = appRes.getContacts().stream().map(ContactResponse::from).toList();
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class DiscountResponse {
        private String id;
        private String type;
        private String condition;
        private BigDecimal amount;

        public static DiscountResponse from(LessonAppResponse.DiscountResponse discount) {
            return DiscountResponse.builder()
                    .id(discount.getId())
                    .type(discount.getType())
                    .condition(discount.getCondition())
                    .amount(discount.getAmount())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ContactResponse {
        private String id;
        private String type;
        private String name;
        private String address;

        public static ContactResponse from(LessonAppResponse.ContactResponse contact) {
            return ContactResponse.builder()
                    .id(contact.getId())
                    .type(contact.getType())
                    .name(contact.getName())
                    .address(contact.getAddress())
                    .build();
        }
    }

    public static String extractDate(LocalDateTime dateTime) {
        return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String extractTime(LocalDateTime dateTime) {
        return dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
