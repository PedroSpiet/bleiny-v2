package com.bleiny.users.dataacess.user.entity;

import com.bleiny.domain.core.valueobjects.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_table")
public class UserEntity {

    @Id
    private  UUID userId;
    private String firstName;
    private String lastName;
    @OneToOne(mappedBy = "user", cascade=CascadeType.PERSIST)
    private TellphoneEntity tellphone;

    @OneToOne(mappedBy = "user", cascade=CascadeType.PERSIST)
    private AddressEntity address;
    private Integer age;
    private Gender gender;
    private LocalDate birthdayDate;
    private String bio;

    @OneToMany(mappedBy = "user", cascade=CascadeType.PERSIST)
    private List<GeolocalizationUserEntity> geolocalizationUser;

    private Boolean isActive;
}
