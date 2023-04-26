package com.bleiny.domain.service;

import com.bleiny.domain.core.UsersDomainService;
import com.bleiny.domain.service.ports.output.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.bleiny")
public class UserTestConfiguration {
    @Bean
    public UserRepository userRepository() {
        return Mockito.mock(UserRepository.class);
    }

    @Bean
    ApplicationDomainEventPublisher applicationDomainEventPublisher() {
        return Mockito.mock(ApplicationDomainEventPublisher.class);
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
