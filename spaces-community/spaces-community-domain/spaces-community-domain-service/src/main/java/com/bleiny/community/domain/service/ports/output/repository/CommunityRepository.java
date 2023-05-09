package com.bleiny.community.domain.service.ports.output.repository;

import com.bleiny.community.domain.core.entity.Community;

public interface CommunityRepository {
    Community saveCommunity(Community community);

    Community findById(Long communityId);
}
