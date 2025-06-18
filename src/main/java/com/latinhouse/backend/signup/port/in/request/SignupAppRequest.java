package com.latinhouse.backend.signup.port.in.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SignupAppRequest {
    String email;
    String password;

    String profileId;
    String nickname;
    String sex;
}
