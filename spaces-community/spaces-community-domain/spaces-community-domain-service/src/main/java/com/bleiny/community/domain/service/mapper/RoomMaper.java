package com.bleiny.community.domain.service.mapper;

import com.bleiny.community.domain.core.entity.Room;
import com.bleiny.community.domain.service.dto.CreateRoomCommand;
import org.springframework.stereotype.Component;

@Component

public class RoomMaper {

    public static Room commandToRoom(CreateRoomCommand roomCommand) {
        return Room
                .builder()
                .roomName(roomCommand.getRoom().getRoomName())
                .id(roomCommand.getRoom().getId())
                .isVoice(roomCommand.getRoom().getIsVoice())
                .community(roomCommand.getRoom().getCommunity())
                .build();
    }
}
