package com.bleiny.community.domain.core.events;

import com.bleiny.commons.domain.events.DomainEvent.DomainEvent;
import com.bleiny.community.domain.core.entity.Community;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class CommunityEvents implements DomainEvent<Community> {
    private final Community community;
    private final ZonedDateTime zonedDateTime;

    public CommunityEvents(Community community, ZonedDateTime zonedDateTime) {
        this.community = community;
        this.zonedDateTime = zonedDateTime;
    }
}
