package com.bleiny.community.domain.core;

import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.core.events.CommunityCreatedEvent;

public interface CommunityDomainService {
    public CommunityCreatedEvent validateAndInitializeCommunity(Community community);
}
