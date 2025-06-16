package com.latinhouse.backend.lesson.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Contact {

    private final String id;      // Optional - 저장된 contact의 고유 ID
    private final String type;    // "P", "K", "I", "Y", "W"
    private final String name;    // 담당자명 또는 별명
    private final String address; // 연락처, 링크, 계정명 등
}
