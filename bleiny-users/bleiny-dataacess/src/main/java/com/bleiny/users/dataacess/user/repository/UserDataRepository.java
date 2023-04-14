package com.bleiny.users.dataacess.user.repository;

import com.bleiny.users.dataacess.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDataRepository extends JpaRepository<UserEntity, UUID> {

}
