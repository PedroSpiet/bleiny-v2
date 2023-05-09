package com.bleiny.community.domain.core.valueobjects;

import com.bleiny.commons.domain.valueobjects.BaseId;

import java.util.UUID;

public class TagId extends BaseId<UUID> {
    public TagId(UUID value) {
        super(value);
    }
}
