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
public class TellphoneEntity {
    private Integer countryCod;

    @Id
    private  UUID id;

    private Integer ddd;

    private Integer number;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
