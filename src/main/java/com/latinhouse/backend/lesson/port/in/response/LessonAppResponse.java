package com.latinhouse.backend.lesson.port.in.response;

import com.latinhouse.backend.lesson.domain.Contact;
import com.latinhouse.backend.lesson.domain.Discount;
import com.latinhouse.backend.lesson.domain.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class LessonAppResponse {

    private Long no;

    private String title;
    private String genre;

    private String instructorLo;
    private String instructorLa;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
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

    public LessonAppResponse(Lesson lesson) {
        this.no = lesson.getNo();
        this.title = lesson.getTitle();
        this.genre = lesson.getGenre().getCode();
        this.instructorLo = lesson.getInstructorLo();
        this.instructorLa = lesson.getInstructorLa();
        this.startDateTime = lesson.getStartDateTime();
        this.endDateTime = lesson.getEndDateTime();
        this.dateTimeSubTexts = lesson.getDateTimeSubTexts();
        this.region = lesson.getRegion();
        this.location = lesson.getLocation();
        this.locationUrl = lesson.getLocationUrl();
        this.price = lesson.getPrice();
        this.maxDiscountAmount = lesson.getMaxDiscountAmount();
        this.discountSubTexts = lesson.getDiscountSubTexts();
        this.bankCode = lesson.getBankCode();
        this.accountNumber = lesson.getAccountNumber();
        this.accountOwner = lesson.getAccountOwner();
        this.notices = lesson.getNotices();
        this.discounts = lesson.getDiscounts().stream().map(DiscountResponse::from).toList();
        this.contacts = lesson.getContacts().stream().map(ContactResponse::from).toList();
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class DiscountResponse {
        private String id;
        private String type;
        private String condition;
        private BigDecimal amount;

        public static DiscountResponse from(Discount discount) {
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

        public static ContactResponse from(Contact contact) {
            return ContactResponse.builder()
                    .id(contact.getId())
                    .type(contact.getType())
                    .name(contact.getName())
                    .address(contact.getAddress())
                    .build();
        }
    }
}
