package com.bleiny.community.domain.service;

import com.bleiny.community.domain.core.events.CommunityCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class ApplicationDomainEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(CommunityCreatedEvent communityCreatedEvent) {
        this.applicationEventPublisher.publishEvent(communityCreatedEvent);
    }
}
