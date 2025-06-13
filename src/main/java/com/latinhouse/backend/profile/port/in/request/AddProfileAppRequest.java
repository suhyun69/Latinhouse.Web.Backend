package com.latinhouse.backend.profile.port.in.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddProfileAppRequest {
    String id;
    String content;
}
