package com.bleiny.domain.service.dto.create;

import com.bleiny.commons.domain.valueobjects.GeolocalizationUser;
import com.bleiny.domain.core.entity.Address;
import com.bleiny.domain.core.entity.Tellphone;
import com.bleiny.domain.core.valueobjects.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class CreateUserCommand {
    @NotNull
    private final UUID userId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Tellphone tellphone;
    @NotNull
    private Address address;
    @NotNull
    private Integer age;
    @NotNull
    private Gender gender;
    @NotNull
    private LocalDate birthdayDate;
    private String bio;
    private List<GeolocalizationUser> geolocalizationUser;
    private Boolean isActive;

}
