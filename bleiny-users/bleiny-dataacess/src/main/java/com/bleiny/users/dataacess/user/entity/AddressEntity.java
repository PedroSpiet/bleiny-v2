package com.bleiny.users.dataacess.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "address_table")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressUuid;
    private String state;
    private String city;

    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
