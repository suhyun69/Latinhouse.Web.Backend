package com.latinhouse.backend.profile.port.out;

import com.latinhouse.backend.profile.domain.Profile;
import com.latinhouse.backend.profile.port.in.request.AddProfileAppRequest;

public interface CreateProfilePort {
    Profile create(AddProfileAppRequest appReq);
}
