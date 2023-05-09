package com.bleiny.community.domain.core.events;

import com.bleiny.commons.domain.events.DomainEvent.DomainEvent;
import com.bleiny.commons.domain.valueobjects.CommunityId;
import com.bleiny.community.domain.core.entity.Community;

import java.time.ZonedDateTime;

public class CommunityCreatedEvent extends CommunityEvents {
    public CommunityCreatedEvent(Community community, ZonedDateTime zonedDateTime) {
        super(community, zonedDateTime);
    }
}
