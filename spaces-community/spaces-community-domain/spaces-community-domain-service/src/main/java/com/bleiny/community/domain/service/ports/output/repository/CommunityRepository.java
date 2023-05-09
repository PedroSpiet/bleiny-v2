package com.bleiny.community.domain.service.ports.output.repository;

import com.bleiny.community.domain.core.entity.Community;

import java.util.Optional;

public interface CommunityRepository {
    Community saveCommunity(Community community);

    Community findById(Long communityId);

    Community findByUuid(String communityUuid);

    void findAndUpdateImage(String uuid, String filename);
}
