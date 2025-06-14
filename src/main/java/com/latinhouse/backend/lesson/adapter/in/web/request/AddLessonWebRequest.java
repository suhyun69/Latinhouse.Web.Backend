package com.latinhouse.backend.lesson.adapter.in.web.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddLessonWebRequest {
    @NotBlank(message = "title must not be null")
    private String title;

    @NotBlank(message = "genre must not be null")
    @Pattern(regexp = "^[SB]$", message = "genre must be 'S' or 'B'")
    private String genre;

    private String instructorLo;
    private String instructorLa;

    @NotBlank(message = "startDate must not be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "startDate must be in 'yyyy-MM-dd' format")
    private String startDate;

    @NotBlank(message = "endDate must not be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "endDate must be in 'yyyy-MM-dd' format")
    private String endDate;

    @NotBlank(message = "startTime must not be null")
    @Pattern(regexp = "\\d{2}:\\d{2}", message = "startTime must be in 'HH:mm' format")
    private String startTime;

    @NotBlank(message = "endTime must not be null")
    @Pattern(regexp = "\\d{2}:\\d{2}", message = "endTime must be in 'HH:mm' format")
    private String endTime;

    private List<String> datetimeSubTexts;

    @NotBlank(message = "region must not be null")
    @Pattern(regexp = "^(GN|HD)$", message = "region must be 'GN' or 'HD'")
    private String region;

    @NotBlank(message = "location must not be null")
    private String location;

    private String locationUrl;

    @NotBlank(message = "price must not be null")
    @Min(value = 0, message = "price must be greater than or equal to 0")
    private BigDecimal price;

    @Valid
    private List<Discount> discounts;
    private BigDecimal maxDiscountAmount;
    private List<String> discountSubTexts;

    @NotBlank(message = "bankCode must not be null")
    private String bankCode;

    @NotBlank(message = "accountNumber must not be null")
    private String accountNumber;

    @NotBlank(message = "accountOwner must not be null")
    private String accountOwner;

    private List<String> notices;

    @Valid
    private List<Contact> contacts;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor // 파라미터 딱 하나 있을 때 필요
    public static class Discount {

        @NotBlank(message = "type must not be null")
        @Pattern(regexp = "^[ES]$", message = "price.type must be 'E' or 'S'")
        // Earlybird, Sex
        private String type;

        @NotBlank(message = "condition must not be null")
        private String condition;

        @NotBlank(message = "amount must not be null.")
        @Min(value = 0, message = "amount must be greater than or equal to 0")
        private BigDecimal amount;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor // 파라미터 딱 하나 있을 때 필요
    public static class Contact {

        @NotBlank(message = "type must not be null.")
        @Pattern(regexp = "^[PKICYW]$", message = "type must be 'P' or 'K' or 'I' or ''Y' or 'W'")
        // Phone, Kakaotalk, Instagram, Youtube, Web
        private String type;

        private String name;

        @NotBlank(message = "address must not be null.")
        private String address;
    }
}
