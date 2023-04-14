package com.bleiny.domain.core.event;

import com.bleiny.domain.core.entity.User;
import lombok.ToString;

import java.time.ZonedDateTime;

@ToString
public class UserCreatedEvent extends UserEvents{
    public UserCreatedEvent(User user, ZonedDateTime zonedDateTime) {
        super(user, zonedDateTime);
    }
}
