package com.bleiny.domain.service;

import com.bleiny.domain.service.dto.patch.PatchImageProfileCommand;
import com.bleiny.domain.service.mapper.UserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class PatchImageProfileCommandHandler {


    private final UserPatchProfileImageHelper helper;

    public PatchImageProfileCommandHandler(UserPatchProfileImageHelper helper) {
        this.helper = helper;
    }

    public void putImage(PatchImageProfileCommand command) throws Exception {
            helper.putImage(command);
    }
}
