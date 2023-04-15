package com.bleiny.domain.core.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Tellphone {
    private String countryCod;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    private UUID id;

    private String ddd;

    private String number;

    public User getUser() {
        return user;
    }

    private User user;

    public Tellphone(String countryCod, UUID id, String ddd, String number, User user) {
        this.countryCod = countryCod;
        this.id = id;
        this.ddd = ddd;
        this.number = number;
        this.user = user;
    }

}
