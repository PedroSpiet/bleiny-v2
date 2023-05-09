package com.bleiny.domain.core.event;

import com.bleiny.commons.domain.events.DomainEvent.DomainEvent;
import com.bleiny.domain.core.entity.User;

import java.time.ZonedDateTime;

public class UserEvents implements DomainEvent<User> {
    private final User user;
    private final ZonedDateTime zonedDateTime;

    public User getUser() {
        return user;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public UserEvents(User user, ZonedDateTime zonedDateTime) {
        this.user = user;
        this.zonedDateTime = zonedDateTime;
    }
}
