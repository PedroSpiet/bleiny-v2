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
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String image;

    @OneToOne(mappedBy = "user", cascade=CascadeType.PERSIST)
    private TellphoneEntity tellphone;

    @OneToOne(mappedBy = "user", cascade=CascadeType.PERSIST)
    private AddressEntity address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String password;

    private String email;

    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthdayDate;
    private String bio;

    @OneToMany(mappedBy = "user", cascade=CascadeType.PERSIST)
    private List<GeolocalizationUserEntity> geolocalizationUser;

    @Column(name = "is_active")
    private Boolean isActive;
}
