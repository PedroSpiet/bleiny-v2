package com.bleiny.community.domain.service.ports;

import com.bleiny.community.domain.core.entity.Room;

public interface RoomRepositoryPort {
    void createRoom(Room room);
}
