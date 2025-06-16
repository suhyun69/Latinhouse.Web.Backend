package com.latinhouse.backend.lesson.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Discount {
    private final String id;        // Optional - 저장된 discount의 고유 ID
    private final String type;      // "E" (Earlybird), "S" (Sex별 할인) 등
    private final String condition; // 예: "3일 전 등록 시"
    private final BigDecimal amount;
}
