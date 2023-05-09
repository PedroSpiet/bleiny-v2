package com.bleiny.community.domain.core.valueobjects;

import com.bleiny.commons.domain.valueobjects.BaseId;

import java.util.UUID;

public class PrivilegeId extends BaseId<UUID> {
    public PrivilegeId(UUID value) {
        super(value);
    }
}
