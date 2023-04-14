package com.bleiny.domain.core.valueobjects;

import com.bleiny.commons.domain.valueobjects.BaseId;

import java.util.UUID;

public class StreetAddress extends BaseId<UUID> {
    public StreetAddress(UUID value) {
        super(value);
    }
}
