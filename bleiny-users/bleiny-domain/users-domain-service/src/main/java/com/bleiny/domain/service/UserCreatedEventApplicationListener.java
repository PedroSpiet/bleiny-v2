package com.bleiny.domain.service;

import com.bleiny.domain.core.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class UserCreatedEventApplicationListener {

    @TransactionalEventListener
    void process(UserCreatedEvent userCreatedEvent) {
        log.info("{}", userCreatedEvent);
    }
}
