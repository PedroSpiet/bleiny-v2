package com.bleiny.community.domain.core.valueobjects;

import com.bleiny.commons.domain.valueobjects.BaseId;

import java.util.UUID;

public class RoleId  extends BaseId<UUID> {
    public RoleId(UUID value) {
        super(value);
    }
}
