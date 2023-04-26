package com.bleiny.users.application.rest;


import com.bleiny.domain.service.UserApplicationServiceImpl;
import com.bleiny.domain.service.UserCreateCommandHandler;
import com.bleiny.domain.service.UserCreateHelper;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.bleiny")
public class UserTestConfiguration {
    @Bean
    public UserController userController() {
        return Mockito.mock(UserController.class);
    }

    @Bean
    public UserApplicationServiceImpl userApplicationServiceImpl() {
        return Mockito.mock(UserApplicationServiceImpl.class);
    }

    @Bean
    public UserCreateCommandHandler userCreateCommandHandler() {
        return Mockito.mock(UserCreateCommandHandler.class);
    }


    @Bean
    public UserCreateHelper userCreateHelper() {
        return Mockito.mock(UserCreateHelper.class);
    }
}

