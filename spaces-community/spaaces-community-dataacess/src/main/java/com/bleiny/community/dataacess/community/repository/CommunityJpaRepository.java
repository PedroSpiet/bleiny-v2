package com.bleiny.community.dataacess.community.repository;

import com.bleiny.community.dataacess.community.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunityJpaRepository extends JpaRepository<CommunityEntity, Long> {
    Optional<CommunityEntity> findByCommunityUuid(String uuid);
}
