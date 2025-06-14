package com.latinhouse.backend.profile.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    private String id;
    private String nickname;
    private Sex sex;
    private Boolean isInstructor;
    private Boolean isAdmin;
}
