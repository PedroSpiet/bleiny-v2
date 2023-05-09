package com.bleiny.community.dataacess.community.adapter;

import com.bleiny.community.dataacess.community.entity.CommunityEntity;
import com.bleiny.community.dataacess.community.mapper.CommunityDataMapper;
import com.bleiny.community.dataacess.community.repository.CommunityJpaRepository;
import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.service.ports.output.repository.CommunityRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommunityRepositoryImpl implements CommunityRepository {
    private final CommunityDataMapper communityDataMapper;
    private final CommunityJpaRepository repository;

    public CommunityRepositoryImpl(CommunityDataMapper communityDataMapper, CommunityJpaRepository repository) {
        this.communityDataMapper = communityDataMapper;
        this.repository = repository;
    }


    @Override
    public Community saveCommunity(Community community) {
        var communityMapper = communityDataMapper.communityToEntity(community);

        try {
            repository.save(communityMapper);
        } catch (Exception e) {
            throw new IllegalStateException("Error on save community");
        }
        return community;
    }

    @Override
    public Community findById(Long communityId) {
        CommunityEntity community = repository.findById(communityId)
                .orElseThrow(() -> new IllegalStateException(("Community Not found!")));


        return communityDataMapper.entityToCommunity(community);
    }

    @Override
    public Community findByUuid(String communityUuid) {
        CommunityEntity community = repository.findByCommunityUuid(communityUuid)
                .orElseThrow(() -> new IllegalStateException(("Community Not found!")));


        return communityDataMapper.entityToCommunity(community);
    }

    @Override
    public void findAndUpdateImage(String uuid, String filename) {
        CommunityEntity community = repository.findByCommunityUuid(uuid)
                .orElseThrow(() -> new IllegalStateException("Community not found"));

        community.setCommunityImage(filename);

        repository.save(community);

    }
}
