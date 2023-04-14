package com.bleiny.users.dataacess.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "geoloc_table")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GeolocalizationUserEntity {
    private String lat;

    private String lon;

    private String maxDistance;

    private Boolean isGlobal;

    @Id
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
