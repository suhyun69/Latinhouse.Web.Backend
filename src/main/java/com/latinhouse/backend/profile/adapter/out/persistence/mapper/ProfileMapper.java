package com.latinhouse.backend.profile.adapter.out.persistence.mapper;

import com.latinhouse.backend.profile.adapter.out.persistence.entity.ProfileJpaEntity;
import com.latinhouse.backend.profile.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileMapper {
    public ProfileJpaEntity mapToJpaEntity(Profile profile) {
        return ProfileJpaEntity.builder()
                .id(profile.getId())
                .content(profile.getContent())
                .build();
    }

    public Profile mapToDomainEntity(ProfileJpaEntity userT) {
        return Profile.builder()
                .id(userT.getId())
                .content(userT.getContent())
                .build();
    }
}
