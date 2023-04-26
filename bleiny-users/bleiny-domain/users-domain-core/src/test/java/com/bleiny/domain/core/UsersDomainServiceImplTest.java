package com.bleiny.domain.core;

import com.bleiny.domain.core.entity.Address;
import com.bleiny.domain.core.entity.Tellphone;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.event.UserCreatedEvent;
import com.bleiny.domain.core.valueobjects.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles(value = "test")
class UsersDomainServiceImplTest {

    @InjectMocks
    public UsersDomainServiceImpl service;

    @Test
    @DisplayName("Should be validate and initializing an user")
    void validateAndInitiateUser() {
        User user = CommonFixture.createUser();

        UserCreatedEvent created = service.validateAndInitiateUser(
                user
        );

        Assertions.assertNotNull(created.getUser().getId());
    }


    @Test
    @DisplayName("Should be validate and initializing an userWithAnInvalidTellphone")
    void mayNotBeAbleToValidateAndInitiateAUserWithAnInvalidTellphone() {
        User user = CommonFixture.createUserInvalidTellphone();

        Throwable error = Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.validateAndInitiateUser(user));

        Assertions.assertEquals("Invalid number", error.getMessage());
    }

    @Test
    void mayNotBeAbleToValidateAndInitiateAUserWithAnInvalidEmail() {
        User user = CommonFixture.createUserInvalidEmail();

        Throwable error = Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.validateAndInitiateUser(user));

        Assertions.assertEquals("Invalid Email", error.getMessage());
    }
}