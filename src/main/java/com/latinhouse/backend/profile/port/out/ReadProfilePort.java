package com.latinhouse.backend.profile.port.out;

import com.latinhouse.backend.profile.domain.Profile;

import java.util.List;
import java.util.Optional;

public interface ReadProfilePort {
    List<Profile> findAll();
    Optional<Profile> findById(String id);
}
