package com.bleiny.domain.core;

import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.event.UserCreatedEvent;

public interface UsersDomainService {
    UserCreatedEvent validateAndInitiateUser(User user);
}
