package com.latinhouse.backend.user.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserWebRequest {
    @NotBlank(message = "email must not be null")
    private String email;

    @NotBlank(message = "password must not be null")
    private String password;
}
