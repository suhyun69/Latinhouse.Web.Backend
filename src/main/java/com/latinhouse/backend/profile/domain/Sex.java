package com.latinhouse.backend.profile.domain;

public enum Sex {
    Male("M"),
    Female("F");

    private final String code;

    Sex(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Sex of(String code) {
        for (Sex sex : values()) {
            if (sex.code.equalsIgnoreCase(code)) {
                return sex;
            }
        }
        throw new IllegalArgumentException("Invalid sex code: " + code);
    }
}
