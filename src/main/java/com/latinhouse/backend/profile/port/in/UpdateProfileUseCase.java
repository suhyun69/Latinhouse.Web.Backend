package com.latinhouse.backend.profile.port.in;

import com.latinhouse.backend.profile.port.in.response.ProfileAppResponse;

public interface UpdateProfileUseCase {
    ProfileAppResponse enrollInstructor(String id);
}
