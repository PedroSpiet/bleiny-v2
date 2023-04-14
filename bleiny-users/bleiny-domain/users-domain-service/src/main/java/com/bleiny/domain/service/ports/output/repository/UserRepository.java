package com.bleiny.domain.service.ports.output.repository;

import com.bleiny.domain.core.entity.User;

public interface UserRepository {
    User save(User user);
}
