package com.bleiny.domain.service.ports.input.service;

import com.bleiny.domain.service.dto.create.CreateUserCommand;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserApplicationService {
    void createUser(@Valid CreateUserCommand createUserCommand);

    ResponseEntity<?> updateProfileImage(String uuid, MultipartFile file);
}
