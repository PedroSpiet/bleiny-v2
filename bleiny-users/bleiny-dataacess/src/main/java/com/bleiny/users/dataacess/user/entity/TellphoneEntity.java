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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tellphone_uuid")
    private  String tellphoneUuid;

    private String ddd;

    @Column(name = "country_code")
    private String countryCod;

    @Column(name = "tellphone_number")
    private String number;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
