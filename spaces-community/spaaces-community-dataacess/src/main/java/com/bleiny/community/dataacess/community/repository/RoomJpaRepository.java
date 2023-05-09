package com.bleiny.community.dataacess.community.repository;

import com.bleiny.community.dataacess.community.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomJpaRepository extends JpaRepository<RoomEntity, Long> {
}
