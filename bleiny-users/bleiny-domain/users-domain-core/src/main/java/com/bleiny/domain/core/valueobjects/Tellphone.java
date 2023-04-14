package com.bleiny.domain.core.valueobjects;

import com.bleiny.commons.domain.valueobjects.BaseId;

import java.util.UUID;

public class Tellphone extends BaseId<UUID> {
    public Tellphone(UUID value) {
        super(value);
    }
}
