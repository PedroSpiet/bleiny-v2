package com.bleiny.users.dataacess.user.adapter;

import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.service.ports.output.repository.UserRepository;
import com.bleiny.users.dataacess.user.entity.UserEntity;
import com.bleiny.users.dataacess.user.maper.UserDataAccessMapper;
import com.bleiny.users.dataacess.user.repository.UserDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private final UserDataRepository userRepository;

    private UserDataAccessMapper userDataMapper;

    public UserRepositoryImpl(UserDataRepository userRepository,
                              UserDataAccessMapper userDataMapper) {
        this.userRepository = userRepository;
        this.userDataMapper = userDataMapper;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userDataMapper.userToEntity(user);
        UserEntity userSaved = userRepository.save(userEntity);
        return userDataMapper.userEntityToUser(userSaved);
    }

    @Override
    public Optional<User> findByUuid(String uuid) {
        var userEntity =  userRepository.findByUserUuid(uuid);
        return  Optional.of(userDataMapper.userEntityToUser(userEntity.get()));

    }

    @Override
    public void findAndUpdateImageProfile(String uuid, String filename) {
        log.info(uuid);
        UserEntity userEntity =  userRepository.findByUserUuid(uuid)
                .orElseThrow(() ->  new IllegalStateException("User Doenst Exist aaa"));

        userEntity.setImage(filename);
        userRepository.save(userEntity);
    }
}
