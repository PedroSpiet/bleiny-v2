package com.bleiny.domain.service;

import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.bleiny.domain.service.dto.patch.PatchImageProfileCommand;
import com.bleiny.domain.service.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserCreateCommandHandler userCreateCommandHandler;

    private final PatchImageProfileCommandHandler patchImageProfileCommandHandler;

    public UserApplicationServiceImpl(UserCreateCommandHandler userCreateCommandHandler, PatchImageProfileCommandHandler patchImageProfileCommandHandler) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.patchImageProfileCommandHandler = patchImageProfileCommandHandler;
    }

    @Override
    public void createUser(CreateUserCommand createUserCommand) {
        userCreateCommandHandler.createUser(createUserCommand);
    }

    @Override
    public ResponseEntity<?> updateProfileImage(String uuid, MultipartFile file) {
        if (uuid == null  || file.isEmpty()) {
            throw new IllegalStateException("UUID Cannot be null");
        }
        PatchImageProfileCommand command = PatchImageProfileCommand
                .builder()
                .userId(uuid)
                .multipartFile(file)
                .build();

            try {
                patchImageProfileCommandHandler.putImage(command);
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new IllegalArgumentException("The Mime Type must be a Image/GIF");
            }
        return ResponseEntity.noContent().build();
    }
}
