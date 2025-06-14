package com.latinhouse.backend.profile.application.service;

import com.latinhouse.backend.global.exception.CustomException;
import com.latinhouse.backend.global.exception.ErrorCode;
import com.latinhouse.backend.profile.domain.Profile;
import com.latinhouse.backend.profile.port.in.AddProfileUseCase;
import com.latinhouse.backend.profile.port.in.FindProfileUseCase;
import com.latinhouse.backend.profile.port.in.UpdateProfileUseCase;
import com.latinhouse.backend.profile.port.in.request.AddProfileAppRequest;
import com.latinhouse.backend.profile.port.in.response.ProfileAppResponse;
import com.latinhouse.backend.profile.port.out.CreateProfilePort;
import com.latinhouse.backend.profile.port.out.ReadProfilePort;
import com.latinhouse.backend.profile.port.out.UpdateProfilePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService implements AddProfileUseCase
        , FindProfileUseCase
        , UpdateProfileUseCase
{

    private final CreateProfilePort createProfilePort;
    private final ReadProfilePort readProfilePort;
    private final UpdateProfilePort updateProfilePort;

    @Override
    public ProfileAppResponse add(AddProfileAppRequest appReq) {
        return new ProfileAppResponse(createProfilePort.create(appReq));
    }

    @Override
    public ProfileAppResponse findById(String id) {
        return readProfilePort.findById(id)
                .map(ProfileAppResponse::new)
                .orElse(null);
    }

    @Override
    public List<ProfileAppResponse> findAll() {
        return readProfilePort.findAll().stream()
                .map(ProfileAppResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileAppResponse enrollInstructor(String id) {

        Optional<Profile> optionalProfile = readProfilePort.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new CustomException(ErrorCode.PROFILE_NOT_FOUND);
        }

        Profile profile = optionalProfile.get();
        profile.setIsInstructor(true);

        Profile updated = updateProfilePort.update(profile);
        return new ProfileAppResponse(updated);
    }
}

