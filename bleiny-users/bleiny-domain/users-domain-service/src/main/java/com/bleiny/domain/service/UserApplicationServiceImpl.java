package com.bleiny.domain.service;

import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.bleiny.domain.service.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserCreateCommandHandler userCreateCommandHandler;

    public UserApplicationServiceImpl(UserCreateCommandHandler userCreateCommandHandler) {
        this.userCreateCommandHandler = userCreateCommandHandler;
    }

    @Override
    public void createUser(CreateUserCommand createUserCommand) {
        userCreateCommandHandler.createUser(createUserCommand);
    }
}
