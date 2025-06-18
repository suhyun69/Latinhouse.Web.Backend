package com.latinhouse.backend.signup.port.in;

import com.latinhouse.backend.signup.port.in.request.SignupAppRequest;
import com.latinhouse.backend.signup.port.in.response.SignupAppResponse;

public interface SignupUseCase {
    SignupAppResponse signupByEmail(SignupAppRequest appReq);
}
