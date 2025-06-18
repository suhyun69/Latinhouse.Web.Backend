package com.latinhouse.backend.signup.application.service;

import com.latinhouse.backend.global.exception.CustomException;
import com.latinhouse.backend.global.exception.ErrorCode;
import com.latinhouse.backend.profile.port.in.AddProfileUseCase;
import com.latinhouse.backend.profile.port.in.request.AddProfileAppRequest;
import com.latinhouse.backend.profile.port.in.response.ProfileAppResponse;
import com.latinhouse.backend.signup.port.in.SignupUseCase;
import com.latinhouse.backend.signup.port.in.request.SignupAppRequest;
import com.latinhouse.backend.signup.port.in.response.SignupAppResponse;
import com.latinhouse.backend.user.port.in.AddUserUseCase;
import com.latinhouse.backend.user.port.in.FindUserUseCase;
import com.latinhouse.backend.user.port.in.request.AddUserAppRequest;
import com.latinhouse.backend.user.port.in.response.UserAppResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService implements SignupUseCase {

    private final AddUserUseCase addUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final AddProfileUseCase addProfileUseCase;

    @Override
    public SignupAppResponse signupByEmail(SignupAppRequest appReq) {

        if (findUserUseCase.findByEmail(appReq.getEmail()).isPresent()) {
            throw new CustomException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }

        AddUserAppRequest addUserAppRequest = AddUserAppRequest.builder()
                .email(appReq.getEmail())
                .password(appReq.getPassword())
                .build();
        UserAppResponse user = addUserUseCase.addByEmail(addUserAppRequest);

        AddProfileAppRequest addProfileAppRequest = AddProfileAppRequest.builder()
                .id(appReq.getProfileId())
                .nickname(appReq.getNickname())
                .sex(appReq.getSex())
                .email(appReq.getEmail())
                .build();
        ProfileAppResponse profile = addProfileUseCase.add(addProfileAppRequest);

        return new SignupAppResponse(user.getEmail(), profile.getId());
    }
}
