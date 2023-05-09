package com.bleiny.community.domain.service;

import com.bleiny.community.domain.core.entity.Room;
import com.bleiny.community.domain.service.dto.CreateRoomCommand;
import com.bleiny.community.domain.service.mapper.RoomMaper;
import com.bleiny.community.domain.service.ports.RoomRepositoryPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateRoomHelper {


    private final RoomRepositoryPort roomRepositoryPort;

    public CreateRoomHelper(RoomRepositoryPort roomRepositoryPort) {
        this.roomRepositoryPort = roomRepositoryPort;
    }

    @Transactional
    public void createRoom(CreateRoomCommand command) {
        Room room = RoomMaper.commandToRoom(command);
        roomRepositoryPort.createRoom(room);
    }
}
