package com.latinhouse.backend.user.port.in;

import com.latinhouse.backend.user.port.in.request.CreateUserAppRequest;
import com.latinhouse.backend.user.port.in.response.UserAppResponse;

public interface CreateUserUseCase {
    UserAppResponse create(CreateUserAppRequest appReq);
}
