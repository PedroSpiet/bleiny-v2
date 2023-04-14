package com.bleiny.domain.service;

import com.bleiny.domain.core.UsersDomainService;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.event.UserCreatedEvent;
import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.bleiny.domain.service.mapper.UserDataMapper;
import com.bleiny.domain.service.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class UserCreateCommandHandler {

    private final UserDataMapper userDataMapper;

    private final UserCreateHelper userCreateHelper;

    public UserCreateCommandHandler(UserDataMapper userDataMapper, UserCreateHelper userCreateHelper) {
        this.userDataMapper = userDataMapper;
        this.userCreateHelper = userCreateHelper;
    }

    @Transactional
    public UserCreatedEvent createUser(CreateUserCommand createUserCommand) {
        UserCreatedEvent userCreatedEvent = userCreateHelper.persistUser(createUserCommand);
        log.info("Order is created with id: {}", userCreatedEvent.getUser().getId().getValue().toString());
        return userCreatedEvent;
    }

}
