package com.bleiny.community.dataacess.community.adapter;

import com.bleiny.community.dataacess.community.entity.RoomEntity;
import com.bleiny.community.dataacess.community.mapper.RoomDataMaper;
import com.bleiny.community.dataacess.community.repository.RoomJpaRepository;
import com.bleiny.community.domain.core.entity.Room;
import com.bleiny.community.domain.service.ports.RoomRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class RoomRepositoryImpl implements RoomRepositoryPort {
    private final RoomJpaRepository repository;

    private final RoomDataMaper maper;

    public RoomRepositoryImpl(RoomJpaRepository repository, RoomDataMaper maper) {
        this.repository = repository;
        this.maper = maper;
    }

    @Override
    public void createRoom(Room room) {
        try {
            RoomEntity roomEntity = maper.roomToEntity(room);
            repository.save(roomEntity);
        } catch (Exception e) {
            throw new IllegalStateException("Error on create Room: " + e.getMessage());
        }
    }
}
