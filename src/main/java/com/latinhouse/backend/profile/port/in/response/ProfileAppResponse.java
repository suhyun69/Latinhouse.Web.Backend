package com.latinhouse.backend.profile.port.in.response;

import com.latinhouse.backend.profile.domain.Profile;
import com.latinhouse.backend.profile.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileAppResponse {
    private String id;
    private String nickname;
    private Sex sex;
    private Boolean isInstructor;

    public ProfileAppResponse(Profile profile) {
        this.id = profile.getId();
        this.nickname = profile.getNickname();
        this.sex = profile.getSex();
        this.isInstructor = profile.getIsInstructor();
    }
}
