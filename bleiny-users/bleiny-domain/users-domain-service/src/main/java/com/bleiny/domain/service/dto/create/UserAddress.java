package com.bleiny.domain.service.dto.create;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UserAddress {
    @NotNull
    private UUID id;
    @NotNull
    private String state;

    @NotNull
    private String city;
    @NotNull
    private String country;
}
