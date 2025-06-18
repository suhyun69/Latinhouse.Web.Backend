package com.latinhouse.backend.signup.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupWebRequest {

    @NotBlank(message = "email must not be null")
    private String email;

    @NotBlank(message = "password must not be null")
    private String password;

    @NotBlank(message = "profieId must not be null")
    private String profileId;

    @NotBlank(message = "nickname must not be null")
    private String nickname;

    @NotBlank(message = "sex must not be null")
    @Pattern(regexp = "^[MF]$", message = "sex must be 'M' or 'F'")
    private String sex;
}
