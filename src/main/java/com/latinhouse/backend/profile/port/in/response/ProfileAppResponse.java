package com.latinhouse.backend.profile.port.in.response;

import com.latinhouse.backend.profile.domain.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileAppResponse {
    private String id;
    private String content;

    public ProfileAppResponse(Profile profile) {
        this.id = profile.getId();
        this.content = profile.getContent();
    }
}
