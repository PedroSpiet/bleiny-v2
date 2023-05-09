package com.bleiny.community.domain.core.entity;

import com.bleiny.commons.domain.valueobjects.BaseId;
import com.bleiny.community.domain.core.dto.CommunityDto;
import com.bleiny.community.domain.core.valueobjects.RoomId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@Builder
public class Room {

    public UUID getId() {
        setId(UUID.randomUUID());
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;

    private String roomName;

    private Boolean isVoice;

    private CommunityDto community;
}
