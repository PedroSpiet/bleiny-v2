package com.bleiny.users.dataacess.user.adapter;

import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.service.ports.output.repository.UserRepository;
import com.bleiny.users.dataacess.user.entity.UserEntity;
import com.bleiny.users.dataacess.user.maper.UserDataAccessMapper;
import com.bleiny.users.dataacess.user.repository.UserDataRepository;
import org.springframework.stereotype.Component;

@Component
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
}
