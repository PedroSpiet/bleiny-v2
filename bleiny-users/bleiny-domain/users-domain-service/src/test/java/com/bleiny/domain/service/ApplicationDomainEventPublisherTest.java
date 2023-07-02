package com.bleiny.domain.service;

import com.bleiny.domain.core.event.UserCreatedEvent;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ApplicationDomainEventPublisherTest {

    @MockBean
    ApplicationDomainEventPublisher service;

    @MockBean
    private ApplicationEventPublisher publisher;

    @BeforeEach
    void setUp() {
        service.setApplicationEventPublisher(publisher);
    }

    @Test
    void shouldBeAbleToPublishAnEvent() {
        service.publish(new UserCreatedEvent(CommonFixture.createUser(), ZonedDateTime.now()));
        verify(service, Mockito.times(1)).publish(Mockito.any(UserCreatedEvent.class));
    }

}