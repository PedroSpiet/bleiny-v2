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

         userEntity.setUserId(user.getId().getValue());
         userEntity.setGeolocalizationUser(
                 geolocalizationUserToEntity(user.getGeolocalizationUser())
                 );
         userEntity.setBio(user.getBio());
         userEntity.setAge(user.getAge());
        userEntity.setGender(user.getGender());
        userEntity.setIsActive(user.getActive());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setBirthdayDate(user.getBirthdayDate());
        userEntity.setTellphone(tellphoneToEntity(user.getTellphone(), userEntity));
        userEntity.setAddress(
                userAddressToAddressEntity(user.getAddress(), userEntity)
        );
        return userEntity;
    }

    private AddressEntity userAddressToAddressEntity(Address address, UserEntity user) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setUser(user);
        addressEntity.setCity(address.getCity());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setState(address.getState());
        addressEntity.setId(address.getId());
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
        tellphone.setCountryCod(tellphone.getCountryCod());
        tellphoneEntity.setNumber(tellphoneEntity.getNumber());
        tellphoneEntity.setDdd(tellphoneEntity.getDdd());
        tellphoneEntity.setId(tellphone.getId());
        return tellphoneEntity;
    }

    public User userEntityToUser(UserEntity userSaved) {
        User user = new User();
        user.setId(new UserId(userSaved.getUserId()));
        user.setGeolocalizationUser(null);
        log.info(String.valueOf(userSaved.getAddress()));
        user.setBio(userSaved.getBio());

        return user;
    }
}
