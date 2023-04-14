package com.bleiny.domain.service;

import com.bleiny.domain.core.UsersDomainService;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.event.UserCreatedEvent;
import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.bleiny.domain.service.mapper.UserDataMapper;
import com.bleiny.domain.service.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class UserCreateHelper {
    private final UsersDomainService usersDomainService;
    private final UserRepository userRepository;

    private final UserDataMapper userDataMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserCreateHelper(UsersDomainService usersDomainService1, UserRepository userRepository, UserDataMapper userDataMapper, ApplicationEventPublisher applicationEventPublisher) {
        this.usersDomainService = usersDomainService1;
        this.userRepository = userRepository;
        this.userDataMapper = userDataMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public UserCreatedEvent persistUser(CreateUserCommand createUserCommand) {
        User converted = userDataMapper.userCommandToUser(createUserCommand);
        UserCreatedEvent userCreatedEvent = usersDomainService.validateAndInitiateUser(
                converted
        );

        log.info("Saving user {}",  userCreatedEvent.getUser().getId().getValue().toString());
        saveUser(converted);
        applicationEventPublisher.publishEvent(userCreatedEvent);
        return userCreatedEvent;
    }

    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            // TODO EXCEPTION
        }
        log.info("Saved with sucessfuly");
        return user;
    }
}
