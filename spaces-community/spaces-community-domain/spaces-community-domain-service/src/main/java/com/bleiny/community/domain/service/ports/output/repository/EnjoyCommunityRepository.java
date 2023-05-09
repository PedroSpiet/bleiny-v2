package com.bleiny.community.domain.service.ports.output.repository;

public interface EnjoyCommunityRepository {
    boolean memberAlreadyInServer(Long idUser, Long idCommunity);

    void save(Long userId, Long communityId);
}
