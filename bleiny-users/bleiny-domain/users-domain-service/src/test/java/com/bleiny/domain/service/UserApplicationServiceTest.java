package com.bleiny.domain.service;


import com.bleiny.domain.core.UsersDomainService;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.event.UserCreatedEvent;
import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.bleiny.domain.service.mapper.UserDataMapper;
import com.bleiny.domain.service.ports.input.service.UserApplicationService;
import com.bleiny.domain.service.ports.output.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = UserTestConfiguration.class,  properties = "spring.main.allow-bean-definition-overriding=true")
public class UserApplicationServiceTest {
    @Autowired
    private UserApplicationService userApplicationService;

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private final UUID USER_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb41");

    private CreateUserCommand userCommand;

    @SpyBean
    UsersDomainService usersDomainService;

    @SpyBean
    UserCreateHelper userCreateHelper;

    @SpyBean
    UserCreateCommandHandler handler;

    @SpyBean
    UserCreatedEventApplicationListener listener;

    @BeforeAll
    public void beforeAll() {
        this.userCommand = CommonFixture.userCreateCommandHandler();

        when(userRepository.save(Mockito.any(User.class))).thenReturn(CommonFixture.createUser());
    }

    @Test
    void shouldBeCreateAnUserCommand() {
        userApplicationService.createUser(this.userCommand);

        verify(usersDomainService, Mockito.times(1)).validateAndInitiateUser(Mockito.any(User.class));
        verify(userCreateHelper, Mockito.times(1)).persistUser(Mockito.any(CreateUserCommand.class));
        verify(handler, Mockito.times(1)).createUser(Mockito.any(CreateUserCommand.class));
        verify(listener, Mockito.times(1)).process(Mockito.any(UserCreatedEvent.class));
    }

    @Test
    void mayNotBeAbleToCreateAUserCommandByErrors() {
        Throwable error = Assertions.assertThrows(Exception.class, () ->
                userApplicationService.createUser(null)
                );
    }

    @Test
    void shouldBeUpdatedAnImagePatch() {
        Throwable error = Assertions.assertThrows(Exception.class, () ->
                userApplicationService.updateProfileImage(null, null)
        );
    }

}
