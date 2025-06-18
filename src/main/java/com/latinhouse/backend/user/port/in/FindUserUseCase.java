package com.latinhouse.backend.user.port.in;

import com.latinhouse.backend.user.port.in.response.UserAppResponse;

import java.util.List;
import java.util.Optional;

public interface FindUserUseCase {
    Optional<UserAppResponse> findByEmail(String email);
    List<UserAppResponse> findAll();
}
