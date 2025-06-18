package com.latinhouse.backend.signup.adapter.in.web;

import com.latinhouse.backend.signup.adapter.in.web.request.SignupWebRequest;
import com.latinhouse.backend.signup.adapter.in.web.response.SignupWebResponse;
import com.latinhouse.backend.signup.port.in.SignupUseCase;
import com.latinhouse.backend.signup.port.in.request.SignupAppRequest;
import com.latinhouse.backend.user.adapter.in.web.request.AddUserWebRequest;
import com.latinhouse.backend.user.adapter.in.web.response.UserWebResponse;
import com.latinhouse.backend.user.port.in.request.AddUserAppRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/signup")
@Tag(name = "Signup", description = "Signup API Document")
@RequiredArgsConstructor
public class ApiV1SignupController {
    private final SignupUseCase signupUseCase;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("")
    @Operation(summary = "Signup", description = "by email")
    public ResponseEntity<SignupWebResponse> addUser(@Valid @RequestBody SignupWebRequest webReq) {

        SignupAppRequest appReq = SignupAppRequest.builder()
                .email(webReq.getEmail())
                .password(passwordEncoder.encode(webReq.getPassword()))
                .profileId(webReq.getProfileId())
                .nickname(webReq.getNickname())
                .sex(webReq.getSex())
                .build();
        SignupWebResponse webRes = new SignupWebResponse(signupUseCase.signupByEmail(appReq));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(webRes);
    }
}
