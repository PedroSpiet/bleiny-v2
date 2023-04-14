package com.bleiny.domain.service;

import com.bleiny.domain.core.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationDomainEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(UserCreatedEvent userCreatedEvent) {
        this.applicationEventPublisher.publishEvent(userCreatedEvent);
        log.info("UserCreatedEvent is published for user id: {}", userCreatedEvent.getUser().getId().getValue().toString());
    }
}
