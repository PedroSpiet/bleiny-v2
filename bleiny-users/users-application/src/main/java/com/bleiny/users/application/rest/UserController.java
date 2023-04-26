package com.bleiny.users.application.rest;

import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.bleiny.domain.service.ports.input.service.UserApplicationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserCommand createUserCommand) {
        userApplicationService.createUser(createUserCommand);
        return ResponseEntity.noContent().build();
    }
}
