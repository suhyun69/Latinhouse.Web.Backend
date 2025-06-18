package com.latinhouse.backend.profile.adapter.out.persistence.mapper;

import com.latinhouse.backend.profile.adapter.out.persistence.entity.ProfileJpaEntity;
import com.latinhouse.backend.profile.domain.Profile;
import com.latinhouse.backend.profile.domain.Sex;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileMapper {
    public ProfileJpaEntity mapToJpaEntity(Profile profile) {
        return ProfileJpaEntity.builder()
                .id(profile.getId())
                .nickname(profile.getNickname())
                .sex(profile.getSex().getCode())
                .isInstructor(profile.getIsInstructor())
                .build();
    }

    public Profile mapToDomainEntity(ProfileJpaEntity userT) {
        return Profile.builder()
                .id(userT.getId())
                .nickname(userT.getNickname())
                .sex(Sex.of(userT.getSex()))
                .isInstructor(userT.getIsInstructor())
                .build();
    }
}
