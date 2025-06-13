package com.latinhouse.backend.profile.port.in;

import com.latinhouse.backend.profile.port.in.request.AddProfileAppRequest;
import com.latinhouse.backend.profile.port.in.response.ProfileAppResponse;

public interface AddProfileUseCase {
    ProfileAppResponse add(AddProfileAppRequest appReq);
}
