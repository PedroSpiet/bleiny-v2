package com.bleiny.domain.service;

import com.bleiny.domain.core.entity.Address;
import com.bleiny.domain.core.entity.Tellphone;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.valueobjects.Gender;
import com.bleiny.domain.service.dto.create.CreateUserCommand;

import java.time.LocalDate;

public class CommonFixture {

    public static User createUser() {
        return User.builder()
                .address(Address
                        .builder()
                        .state("SP")
                        .country("Brazil")
                        .city("Guarujá").build())
                .bio("Hi")
                .geolocalizationUser(null)
                .birthdayDate(LocalDate.of(2002, 04, 04))
                .firstName("Pedro")
                .gender(Gender.MAN)
                .email("pedrospiet@gmail.com")
                .password("123455")
                .isActive(Boolean.TRUE)
                .lastName("Silva")
                .tellphone(Tellphone
                        .builder()
                        .countryCod("+55")
                        .ddd("13")
                        .number("996403089")
                        .user(new User())
                        .build())
                .username("PedroSpiet")
                .build();
    }

    public static User createUserInvalidTellphone() {
        return User.builder()
                .address(Address
                        .builder()
                        .state("SP")
                        .country("Brazil")
                        .city("Guarujá").build())
                .bio("Hi")
                .geolocalizationUser(null)
                .birthdayDate(LocalDate.of(2002, 04, 04))
                .firstName("Pedro")
                .gender(Gender.MAN)
                .email("pedrospiet@gmail.com")
                .password("123455")
                .isActive(Boolean.TRUE)
                .lastName("Silva")
                .tellphone(Tellphone
                        .builder()
                        .countryCod("+55")
                        .ddd("13")
                        .number(null)
                        .user(new User())
                        .build())
                .username("PedroSpiet")
                .build();
    }

    public static User createUserInvalidEmail() {
        return User.builder()
                .address(Address
                        .builder()
                        .state("SP")
                        .country("Brazil")
                        .city("Guarujá").build())
                .bio("Hi")
                .geolocalizationUser(null)
                .birthdayDate(LocalDate.of(2002, 04, 04))
                .firstName("Pedro")
                .gender(Gender.MAN)
                .email("pedrospietgmail.com")
                .password("123455")
                .isActive(Boolean.TRUE)
                .lastName("Silva")
                .tellphone(Tellphone
                        .builder()
                        .countryCod("+55")
                        .ddd("13")
                        .number("996403089")
                        .user(new User())
                        .build())
                .username("PedroSpiet")
                .build();
    }

    public static CreateUserCommand userCreateCommandHandler() {
        return CreateUserCommand.builder()
                .address(Address
                        .builder()
                        .state("SP")
                        .country("Brazil")
                        .city("Guarujá").build())
                .bio("Hi")
                .geolocalizationUser(null)
                .birthdayDate(LocalDate.of(2002, 04, 04))
                .firstName("Pedro")
                .gender(Gender.MAN)
                .email("pedrospiet@gmail.com")
                .password("123455")
                .isActive(Boolean.TRUE)
                .lastName("Silva")
                .tellphone(Tellphone
                        .builder()
                        .countryCod("+55")
                        .ddd("13")
                        .number("996403089")
                        .user(createUser())
                        .build())
                .username("PedroSpiet")
                .build();
    }
}
