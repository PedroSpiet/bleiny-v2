package com.bleiny.domain.service.ports.output.repository;

import com.bleiny.domain.core.entity.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findByUuid(String uuid);

    void findAndUpdateImageProfile(String uuid, String filename);
}
