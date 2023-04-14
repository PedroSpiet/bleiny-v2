package com.bleiny.domain.core;

import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
@Component
public class UsersDomainServiceImpl implements UsersDomainService {
    @Override
    public UserCreatedEvent validateAndInitiateUser(User user) {
        validateInfoUsers(user);
        user.initiateCreation();
        log.info("creating User initiated {}", user.getId().getValue());
        return new UserCreatedEvent(user, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    public void validateInfoUsers(User user) {
        // TODO
    }
}
