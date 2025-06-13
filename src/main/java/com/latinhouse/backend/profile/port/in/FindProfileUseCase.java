package com.latinhouse.backend.profile.port.in;

import com.latinhouse.backend.profile.port.in.response.ProfileAppResponse;

import java.util.List;

public interface FindProfileUseCase {
    ProfileAppResponse findById(String id);
    List<ProfileAppResponse> findAll();
}
