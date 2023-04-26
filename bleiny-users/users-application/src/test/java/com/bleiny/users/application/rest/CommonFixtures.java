package com.bleiny.users.application.rest;

import com.bleiny.domain.core.entity.Address;
import com.bleiny.domain.core.entity.Tellphone;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.core.valueobjects.Gender;
import com.bleiny.domain.service.UserCreateCommandHandler;
import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.time.LocalDate;

public class CommonFixtures {
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
                        .user(new User())
                        .build())
                .username("PedroSpiet")
                .build();
    }
}
