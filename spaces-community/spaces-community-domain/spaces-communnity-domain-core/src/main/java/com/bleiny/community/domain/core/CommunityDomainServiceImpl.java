package com.bleiny.community.domain.core;

import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.core.events.CommunityCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
@Slf4j
public class CommunityDomainServiceImpl implements CommunityDomainService{
    @Override
    public CommunityCreatedEvent validateAndInitializeCommunity(Community community) {
        community.initiateCreation();
        return new CommunityCreatedEvent(community, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
