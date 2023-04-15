package com.bleiny.users.dataacess.user.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tellphone_table")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TellphoneEntity {
    private Integer countryCod;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String tellphoneUuid;

    private Integer ddd;

    private Integer number;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
