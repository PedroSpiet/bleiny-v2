package com.bleiny.community.domain.service;


import com.bleiny.community.domain.core.events.CommunityCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class CommunityCreatedApplicationListener {

    @TransactionalEventListener
    public void communityCreatedEventListener(CommunityCreatedEvent communityCreatedEvent) {
        log.info("Community Created: {}", communityCreatedEvent);
    }
}
