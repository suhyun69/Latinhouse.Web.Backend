package com.latinhouse.backend.profile.port.in.request;

import com.latinhouse.backend.profile.domain.Sex;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddProfileAppRequest {
    String id;
    String nickname;
    Sex sex;
}
