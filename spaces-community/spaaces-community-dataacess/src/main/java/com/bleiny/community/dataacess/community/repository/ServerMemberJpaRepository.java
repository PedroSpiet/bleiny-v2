package com.bleiny.community.dataacess.community.repository;

import com.bleiny.community.dataacess.community.entity.ServerMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerMemberJpaRepository extends JpaRepository<ServerMemberEntity, Long> {
    boolean existsByUserIdAndCommunityId(Long idUser, Long idCommunity);

}
