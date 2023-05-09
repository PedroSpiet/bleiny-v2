package com.bleiny.community.domain.core.valueobjects;

import com.bleiny.commons.domain.valueobjects.BaseId;

import java.util.UUID;

public class TagServerId  extends BaseId<UUID> {
    public TagServerId(UUID value) {
        super(value);
    }
}
