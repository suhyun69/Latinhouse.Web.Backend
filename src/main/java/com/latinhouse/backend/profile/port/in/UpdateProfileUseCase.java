package com.latinhouse.backend.profile.port.in;

import com.latinhouse.backend.profile.port.in.request.UpdateProfileAppRequest;
import com.latinhouse.backend.profile.port.in.response.ProfileAppResponse;

public interface UpdateProfileUseCase {
    ProfileAppResponse update(String id, UpdateProfileAppRequest appReq);
}
