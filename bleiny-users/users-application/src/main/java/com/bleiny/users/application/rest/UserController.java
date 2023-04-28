package com.bleiny.users.application.rest;

import com.bleiny.domain.service.dto.create.CreateUserCommand;
import com.bleiny.domain.service.ports.input.service.UserApplicationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserCommand createUserCommand) {
        userApplicationService.createUser(createUserCommand);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{uuid}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> patchImageProfile(@PathVariable String uuid,
                                               @RequestParam("file") MultipartFile file) {
        return userApplicationService.updateProfileImage(uuid, file);

    }
}
