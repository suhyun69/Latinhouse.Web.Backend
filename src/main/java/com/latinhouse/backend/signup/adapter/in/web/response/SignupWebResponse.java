package com.latinhouse.backend.signup.adapter.in.web.response;

import com.latinhouse.backend.signup.port.in.response.SignupAppResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupWebResponse {
    private String email;
    private String profileId;

    public SignupWebResponse(SignupAppResponse appRes) {
        this.email = appRes.getEmail();
        this.profileId = appRes.getProfileId();
    }
}
