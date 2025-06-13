package com.latinhouse.backend.profile.adapter.in.web.response;

import com.latinhouse.backend.profile.port.in.response.ProfileAppResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileWebResponse {
    private String id;
    private String content;

    public ProfileWebResponse(ProfileAppResponse appRes) {
        this.id = appRes.getId();
        this.content = appRes.getContent();
    }
}
