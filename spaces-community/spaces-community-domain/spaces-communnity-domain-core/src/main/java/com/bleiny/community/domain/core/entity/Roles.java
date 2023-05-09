package com.bleiny.community.domain.core.entity;

import com.bleiny.commons.domain.valueobjects.BaseId;
import com.bleiny.community.domain.core.valueobjects.RoleId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Setter
@Getter
@Builder
public class Roles {
    public UUID getId() {
        setId(UUID.randomUUID());
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;

    private String roleName;

    private List<Privileges> privileges;
}
