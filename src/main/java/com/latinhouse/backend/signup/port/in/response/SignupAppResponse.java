package com.latinhouse.backend.signup.port.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupAppResponse {
    private String email;
    private String profileId;
}
