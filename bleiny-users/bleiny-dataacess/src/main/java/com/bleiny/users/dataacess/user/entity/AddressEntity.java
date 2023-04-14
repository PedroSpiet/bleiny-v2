package com.bleiny.users.dataacess.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "address_table")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressEntity {
    @Id
    private UUID id;
    private String state;
    private String city;

    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
