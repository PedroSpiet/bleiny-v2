package com.bleiny.domain.service.dto.create;

import com.bleiny.commons.domain.valueobjects.GeolocalizationUser;
import com.bleiny.domain.core.entity.Address;
import com.bleiny.domain.core.entity.Tellphone;
import com.bleiny.domain.core.valueobjects.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserCommand {

    private UUID userId;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Tellphone tellphone;
    @NotNull
    private Address address;
    @NotNull
    private Gender gender;
    @NotNull
    private String password;

    @NotNull
    private String username;

    @NotNull
    @Email
    private String email;

    private String image;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdayDate;
    private String bio;
    private List<GeolocalizationUser> geolocalizationUser;
    private Boolean isActive;

}
