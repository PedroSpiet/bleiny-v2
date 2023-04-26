package com.bleiny.domain.core.entity;

import com.bleiny.commons.domain.enity.AggregateRoot;
import com.bleiny.commons.domain.valueobjects.GeolocalizationUser;
import com.bleiny.commons.domain.valueobjects.UserId;
import com.bleiny.domain.core.valueobjects.Gender;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends AggregateRoot<UserId> {
    private String firstName;
    private String lastName;
    private Tellphone tellphone;
    private Address address;
    private String password;
    private String username;
    private String email;
    private Gender gender;
    private String image;
    private LocalDate birthdayDate;

    private String bio;


    private List<GeolocalizationUser> geolocalizationUser;

    private Boolean isActive;

    public void initiateCreation() {
        super.setId(new UserId(UUID.randomUUID()));
        address.setId(UUID.randomUUID());
        tellphone.setId(UUID.randomUUID());
        isActive = Boolean.TRUE;

    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Tellphone getTellphone() {
        return tellphone;
    }

    public Address getAddress() {
        return address;
    }


    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public String getBio() {
        return bio;
    }


    public List<GeolocalizationUser> getGeolocalizationUser() {
        return geolocalizationUser;
    }

    public Boolean getActive() {
        return isActive;
    }


}
