package com.bleiny.domain.service.ports.input.service;

import com.bleiny.domain.service.dto.create.CreateUserCommand;
import jakarta.validation.Valid;

public interface UserApplicationService {
    void createUser(@Valid CreateUserCommand createUserCommand);
}
