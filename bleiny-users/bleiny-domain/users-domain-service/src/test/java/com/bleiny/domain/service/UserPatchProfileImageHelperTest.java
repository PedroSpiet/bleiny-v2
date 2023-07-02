package com.bleiny.domain.service;

import com.bleiny.domain.core.UsersDomainService;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.service.dto.patch.PatchImageProfileCommand;
import com.bleiny.domain.service.mapper.UserDataMapper;
import com.bleiny.domain.service.ports.output.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = UserTestConfiguration.class, properties = "spring.main.allow-bean-definition-overriding=true")
class UserPatchProfileImageHelperTest {

    @Autowired
    @SpyBean
    UserPatchProfileImageHelper userPatchProfileImageHelper;

    @MockBean
    UsersDomainService usersDomainService;

    @MockBean
    UserDataMapper userDataMapper;

    @Autowired
    UserRepository userRepository;


    @BeforeAll
    public void beforeAll() {
        when(userRepository.findByUuid(Mockito.anyString())).thenReturn(Optional.of(CommonFixture.createUser()));
    }

    @Test
    void shouldThrowExceptionBecauseFileIsNotImage() {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );

        MockMultipartFile file2
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "".getBytes()
        );
        Throwable err = Assertions.assertThrows(Exception.class, () -> {
            userPatchProfileImageHelper.putImage(PatchImageProfileCommand.builder()
                    .userId("asdasd")
                    .multipartFile(file).build());
        });

        Throwable err2 = Assertions.assertThrows(Exception.class, () -> {
            userPatchProfileImageHelper.putImage(PatchImageProfileCommand.builder()
                    .userId("asdasd")
                    .multipartFile(file2).build());
        });
    }


    @Test
    void shouldBeAcceptedAValidMultipart() throws Exception {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.png",
                MediaType.IMAGE_JPEG_VALUE,
                "Hello, World!".getBytes()
        );
        UserRepository u = Mockito.mock(UserRepository.class);

        when(u.findByUuid("asdasd")).thenReturn(Optional.of(CommonFixture.createUser()));

        userPatchProfileImageHelper.putImage(PatchImageProfileCommand.builder()
                .userId("asdasd")
                .multipartFile(file).build());

        Mockito.verify(userPatchProfileImageHelper, Mockito.times(1)).isImage(Mockito.any());
    }

    @Test
    void shouldReturnAnUserToUpdateImage() {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.png",
                MediaType.IMAGE_JPEG_VALUE,
                "Hello, World!".getBytes()
        );
        UserRepository u = Mockito.mock(UserRepository.class);

        when(u.findByUuid("asdasd")).thenReturn(Optional.of(CommonFixture.createUser()));

        var user = userPatchProfileImageHelper.findUserByUuid("asdasd");

        Assertions.assertEquals(CommonFixture.createUser().getEmail(), user.getEmail());
    }
}