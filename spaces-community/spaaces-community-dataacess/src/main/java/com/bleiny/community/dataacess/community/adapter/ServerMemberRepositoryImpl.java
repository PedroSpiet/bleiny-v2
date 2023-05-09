package com.bleiny.community.dataacess.community.adapter;

import com.bleiny.community.dataacess.community.entity.CommunityEntity;
import com.bleiny.community.dataacess.community.entity.ServerMemberEntity;
import com.bleiny.community.dataacess.community.repository.CommunityJpaRepository;
import com.bleiny.community.dataacess.community.repository.ServerMemberJpaRepository;
import com.bleiny.community.dataacess.community.repository.UserJpaRepository;
import com.bleiny.community.dataacess.user.UserEntity;
import com.bleiny.community.domain.service.ports.output.repository.EnjoyCommunityRepository;
import org.springframework.stereotype.Component;

@Component
public class ServerMemberRepositoryImpl implements EnjoyCommunityRepository {
    private final ServerMemberJpaRepository enjoyMemberJpaRepository;

    private final CommunityJpaRepository communityJpaRepository;

    private final UserJpaRepository userJpaRepository;

    public ServerMemberRepositoryImpl(ServerMemberJpaRepository enjoyMemberJpaRepository, CommunityJpaRepository communityJpaRepository, UserJpaRepository userJpaRepository) {
        this.enjoyMemberJpaRepository = enjoyMemberJpaRepository;
        this.communityJpaRepository = communityJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public boolean memberAlreadyInServer(Long idUser, Long idCommunity) {
        return enjoyMemberJpaRepository.existsByUserIdAndCommunityId(idUser, idCommunity);
    }

    @Override
    public void save(Long userId, Long communityId) {
        CommunityEntity community = communityJpaRepository.findById(communityId)
                .orElseThrow(() -> new IllegalStateException("Community not found"));

        UserEntity userEntity = userJpaRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        ServerMemberEntity serverMember = ServerMemberEntity
                .builder()
                .community(community)
                .user(userEntity)
                .build();

        enjoyMemberJpaRepository.save(serverMember);
    }
}
