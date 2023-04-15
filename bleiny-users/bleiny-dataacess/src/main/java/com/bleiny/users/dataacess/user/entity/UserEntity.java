package com.bleiny.users.dataacess.user.entity;

import com.bleiny.domain.core.valueobjects.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String userUuid;
    private String firstName;
    private String lastName;
    @OneToOne(mappedBy = "user", cascade=CascadeType.PERSIST)
    private TellphoneEntity tellphone;

    @OneToOne(mappedBy = "user", cascade=CascadeType.PERSIST)
    private AddressEntity address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthdayDate;
    private String bio;

    @OneToMany(mappedBy = "user", cascade=CascadeType.PERSIST)
    private List<GeolocalizationUserEntity> geolocalizationUser;

    private Boolean isActive;
}
