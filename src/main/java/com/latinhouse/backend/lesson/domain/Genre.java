package com.latinhouse.backend.lesson.domain;

import com.latinhouse.backend.profile.domain.Sex;

public enum Genre {
    Salsa("S"),
    Bachata("B");

    private final String code;

    Genre(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Genre of(String code) {
        for (Genre genre : values()) {
            if (genre.code.equalsIgnoreCase(code)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Invalid genre code: " + code);
    }
}
