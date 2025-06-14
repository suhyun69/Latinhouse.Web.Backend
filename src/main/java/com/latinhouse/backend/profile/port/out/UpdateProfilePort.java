package com.latinhouse.backend.profile.port.out;

import com.latinhouse.backend.profile.domain.Profile;

public interface UpdateProfilePort {
    Profile update(Profile profile);
}
