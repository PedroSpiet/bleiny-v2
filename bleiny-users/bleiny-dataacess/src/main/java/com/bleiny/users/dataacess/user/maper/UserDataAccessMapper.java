package com.bleiny.users.dataacess.user.maper;

import com.bleiny.commons.domain.valueobjects.GeolocalizationUser;
import com.bleiny.commons.domain.valueobjects.UserId;
import com.bleiny.domain.core.entity.Address;
import com.bleiny.domain.core.entity.Tellphone;
import com.bleiny.domain.core.entity.User;
import com.bleiny.users.dataacess.user.entity.AddressEntity;
import com.bleiny.users.dataacess.user.entity.GeolocalizationUserEntity;
import com.bleiny.users.dataacess.user.entity.TellphoneEntity;
import com.bleiny.users.dataacess.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserDataAccessMapper {

    private ModelMapper mapper;

    public UserDataAccessMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UserEntity userToEntity(User user) {
         UserEntity userEntity = new UserEntity();

         userEntity.setUserUuid(user.getId().getValue().toString());
         userEntity.setGeolocalizationUser(
                 geolocalizationUserToEntity(user.getGeolocalizationUser())
                 );
         userEntity.setBio(user.getBio());
        userEntity.setGender(user.getGender());
        userEntity.setIsActive(user.getActive());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setBirthdayDate(user.getBirthdayDate());
        userEntity.setTellphone(tellphoneToEntity(user.getTellphone(), userEntity));
        userEntity.setAddress(
                userAddressToAddressEntity(user.getAddress(), userEntity)
        );
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setUsername(user.getUsername());
        userEntity.setImage(user.getImage());
        return userEntity;
    }

    private AddressEntity userAddressToAddressEntity(Address address, UserEntity user) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setUser(user);
        addressEntity.setCity(address.getCity());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setState(address.getState());
        addressEntity.setAddressUuid(address.getId().toString());
        return addressEntity;
    }

    public List<GeolocalizationUserEntity> geolocalizationUserToEntity(List<GeolocalizationUser> geolocalizationUser) {
        if (geolocalizationUser == null  || geolocalizationUser.isEmpty()) {
            return List.of();
        }
        return geolocalizationUser
                .stream().map(g -> mapper.map(g, GeolocalizationUserEntity.class)).collect(Collectors.toList());
    }
    
    private TellphoneEntity tellphoneToEntity(Tellphone tellphone, UserEntity user) {
        TellphoneEntity tellphoneEntity = new TellphoneEntity();
        tellphoneEntity.setUser(user);
        tellphoneEntity.setCountryCod(tellphone.getCountryCod());
        tellphoneEntity.setNumber(tellphone.getNumber());
        tellphoneEntity.setDdd(tellphone.getDdd());
        tellphoneEntity.setTellphoneUuid(tellphone.getId().toString());
        return tellphoneEntity;
    }

    public User userEntityToUser(UserEntity userSaved) {
        var user =  User
                .builder()
                .geolocalizationUser(null)
                .tellphone(Tellphone.builder()
                        .number(userSaved.getTellphone().getNumber())
                        .countryCod(userSaved.getTellphone().getCountryCod())
                        .ddd(userSaved.getTellphone().getDdd())
                        .build())
                .bio(userSaved.getBio())
                .birthdayDate(userSaved.getBirthdayDate())
                .image(userSaved.getImage())
                .address(Address.builder()
                        .id(UUID.fromString(userSaved.getAddress().getAddressUuid()))
                        .city(userSaved.getAddress().getCity())
                        .state(userSaved.getAddress().getState())
                        .country(userSaved.getAddress().getCountry())
                        .build())
                .email(userSaved.getEmail())
                .firstName(userSaved.getFirstName())
                .gender(userSaved.getGender())
                .isActive(userSaved.getIsActive())
                .lastName(userSaved.getLastName())
                .isActive(userSaved.getIsActive())
                .password(userSaved.getPassword())
                .username(userSaved.getUsername())
                .build();

        return user;
    }
}
