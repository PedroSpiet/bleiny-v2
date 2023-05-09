package com.bleiny.community.domain.service;

import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.service.dto.EnjoyCommunityCommand;
import com.bleiny.community.domain.service.ports.output.repository.CommunityRepository;
import com.bleiny.community.domain.service.ports.output.repository.EnjoyCommunityRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class EnjoyCommunityHelper {
    private final EnjoyCommunityRepository enjoyCommunityRepository;

    private final CommunityRepository communityRepository;


    public EnjoyCommunityHelper(EnjoyCommunityRepository enjoyCommunityRepository, CommunityRepository communityRepository) {
        this.enjoyCommunityRepository = enjoyCommunityRepository;
        this.communityRepository = communityRepository;
    }

    @Transactional
    public void enjoyCommunity(EnjoyCommunityCommand command) throws Exception {
        try {
            if (memberAlreadyInCommunity(command.getUserId(), command.getCommunityId())) {
                throw new IllegalStateException("Error on enjoying community, already it" );
            }

            Community community = communityRepository.findById(command.getCommunityId());

            community.setMembersQuantity(community.getMembersQuantity() + 1);

            enjoyCommunityRepository.save(command.getUserId(), command.getCommunityId());
            communityRepository.saveCommunity(community);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new IllegalStateException("Errorr on enjoy community");
        }
    }

    public boolean memberAlreadyInCommunity(Long idUser, Long idCommunity) {
        return enjoyCommunityRepository.memberAlreadyInServer(idUser, idCommunity);
    }
}
