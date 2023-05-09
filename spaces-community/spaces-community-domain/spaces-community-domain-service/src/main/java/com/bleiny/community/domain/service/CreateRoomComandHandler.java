package com.bleiny.community.domain.service;


import com.bleiny.community.domain.service.dto.CreateRoomCommand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateRoomComandHandler {
    private final CreateRoomHelper createRoomHelper;

    public CreateRoomComandHandler(CreateRoomHelper createRoomHelper) {
        this.createRoomHelper = createRoomHelper;
    }

    @Transactional
    public void handle(CreateRoomCommand command) {
        createRoomHelper.createRoom(command);
    }
}
