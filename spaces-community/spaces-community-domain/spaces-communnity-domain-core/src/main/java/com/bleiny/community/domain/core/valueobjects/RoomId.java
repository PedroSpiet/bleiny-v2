package com.bleiny.community.domain.core.valueobjects;

import com.bleiny.commons.domain.valueobjects.BaseId;

import java.util.UUID;

public class RoomId extends BaseId<UUID> {
    public RoomId(UUID value) {
        super(value);
    }
}
