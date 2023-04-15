package com.bleiny.domain.core;

import com.bleiny.domain.core.entity.Tellphone;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
@Component
public class UsersDomainServiceImpl implements UsersDomainService {
    @Override
    public UserCreatedEvent validateAndInitiateUser(User user) {
        validateInfoUsers(user);
        user.initiateCreation();
        log.info("creating User initiated {}", user.getId().getValue());
        return new UserCreatedEvent(user, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    public void validateInfoUsers(User user) {
        validateTellphone(user.getTellphone());
        validateEmail(user.getEmail());
    }

    private void validateEmail(String email) {
        if (email == null ||
                !email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
            throw new IllegalArgumentException("Invalid Email");
        }
    }

    private void validateTellphone(Tellphone tellphone) {
        String number = tellphone.getDdd() + tellphone.getNumber();
        if (number == null) {
            throw new IllegalArgumentException("Number is necessary!");
        }
        if (!number.matches("^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")) {
            throw new IllegalArgumentException("Invalid number");
        }
    }
}
