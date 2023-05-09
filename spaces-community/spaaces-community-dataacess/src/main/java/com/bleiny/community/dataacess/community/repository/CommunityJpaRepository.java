package com.bleiny.community.dataacess.community.repository;

import com.bleiny.community.dataacess.community.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityJpaRepository extends JpaRepository<CommunityEntity, Long> {
}
