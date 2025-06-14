package com.latinhouse.backend.profile.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddProfileWebRequest {
    @NotBlank(message = "id must not be null")
    private String id;

    @NotBlank(message = "nickname must not be null")
    private String nickname;

    @NotBlank(message = "sex must not be null")
    @Pattern(regexp = "^[MF]$", message = "sex must be 'M' or 'F'")
    private String sex;
}
