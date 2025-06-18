package com.latinhouse.backend.profile.adapter.out.persistence;

import com.latinhouse.backend.profile.adapter.out.persistence.entity.ProfileJpaEntity;
import com.latinhouse.backend.profile.adapter.out.persistence.mapper.ProfileMapper;
import com.latinhouse.backend.profile.adapter.out.persistence.repository.ProfileRepository;
import com.latinhouse.backend.profile.domain.Profile;
import com.latinhouse.backend.profile.port.in.request.AddProfileAppRequest;
import com.latinhouse.backend.profile.port.out.CreateProfilePort;
import com.latinhouse.backend.profile.port.out.ReadProfilePort;
import com.latinhouse.backend.profile.port.out.UpdateProfilePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfilePersistenceAdapter implements CreateProfilePort
        , ReadProfilePort
        , UpdateProfilePort
{

    private final ProfileMapper profileMapper;
    private final ProfileRepository profileRepository;

    @Override
    public Profile create(AddProfileAppRequest appReq) {

        ProfileJpaEntity profileT = ProfileJpaEntity.builder()
                .id(appReq.getId())
                .nickname(appReq.getNickname())
                .sex(appReq.getSex())
                .isInstructor(false)
                .email(appReq.getEmail())
                .build();
        return profileMapper.mapToDomainEntity(profileRepository.save(profileT));
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll().stream()
                .map(profileMapper::mapToDomainEntity)
                .toList();
    }

    @Override
    public Optional<Profile> findById(String id) {
        return profileRepository.findById(id)
                .map(profileMapper::mapToDomainEntity);
    }

    @Override
    public Profile update(Profile profile) {
        ProfileJpaEntity profileT = profileMapper.mapToJpaEntity(profile);
        ProfileJpaEntity updated = profileRepository.save(profileT);
        return profileMapper.mapToDomainEntity(updated);
    }
}
