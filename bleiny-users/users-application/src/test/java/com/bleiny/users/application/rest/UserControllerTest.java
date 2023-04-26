package com.bleiny.users.application.rest;


import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = UserTestConfiguration.class, properties = "spring.main.allow-bean-definition-overriding=true")
@ActiveProfiles("test")
@AutoConfigureMockMvc
class UserControllerTest {
    private final String BASE_URL = "/users";

    @Autowired
    public MockMvc mockMvc;

    @Test
    @DisplayName("Should be create a user")
    void shouldBeCreateAUser() throws Exception {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());

        CreateUserCommand createUserCommand = CommonFixtures.userCreateCommandHandler();
        String json = mapper.writeValueAsString(createUserCommand);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(BASE_URL)
                .content(json)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is2xxSuccessful());

    }

    @Test
    @DisplayName("Should not create a user with invalid parameters")
    void mayNotBeAbleToCreateAUser() throws Exception {
        CreateUserCommand command = new CreateUserCommand();

        String json = new ObjectMapper().writeValueAsString(command);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}