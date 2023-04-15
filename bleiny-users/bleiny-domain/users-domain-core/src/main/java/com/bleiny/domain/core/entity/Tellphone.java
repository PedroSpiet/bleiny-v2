package com.bleiny.domain.core.entity;

import java.util.UUID;

public class Tellphone {
    private Integer countryCod;

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

    public Tellphone(Integer countryCod, UUID id, String ddd, String number, User user) {
        this.countryCod = countryCod;
        this.id = id;
        this.ddd = ddd;
        this.number = number;
        this.user = user;
    }

    public Integer getCountryCod() {
        return countryCod;
    }

    public void setCountryCod(Integer countryCod) {
        this.countryCod = countryCod;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
