package com.latinhouse.backend.user.port.in;

import com.latinhouse.backend.user.port.in.request.AddUserAppRequest;
import com.latinhouse.backend.user.port.in.response.UserAppResponse;

public interface AddUserUseCase {
    UserAppResponse addByEmail(AddUserAppRequest appReq);
}
