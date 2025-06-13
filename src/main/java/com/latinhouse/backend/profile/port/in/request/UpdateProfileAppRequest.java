package com.latinhouse.backend.profile.port.in.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateProfileAppRequest {
    String id;
    String content;
}
