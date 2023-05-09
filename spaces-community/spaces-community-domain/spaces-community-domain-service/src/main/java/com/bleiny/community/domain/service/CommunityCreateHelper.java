package com.bleiny.community.domain.service;

import com.bleiny.community.domain.core.CommunityDomainService;
import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.core.events.CommunityCreatedEvent;
import com.bleiny.community.domain.service.dto.CreateCommunityCommand;
import com.bleiny.community.domain.service.mapper.CommunityMapper;
import com.bleiny.community.domain.service.ports.output.repository.CommunityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class CommunityCreateHelper {

    private final ApplicationDomainEventPublisher applicationEventPublisher;
    private final CommunityMapper communityMapper;

    private final CommunityRepository communityRepository;

    private final CommunityDomainService communityDomainService;

    public CommunityCreateHelper(ApplicationDomainEventPublisher applicationEventPublisher, CommunityMapper
            communityMapper, CommunityRepository communityRepository, CommunityDomainService communityDomainService) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.communityMapper = communityMapper;
        this.communityRepository = communityRepository;
        this.communityDomainService = communityDomainService;
    }

    @Transactional
    public CommunityCreatedEvent persistCommunity(CreateCommunityCommand command) {
        Community community = communityMapper
                .CreateCommunityCommandToCommunity(command);

        CommunityCreatedEvent communityCreatedEvent =
                communityDomainService.validateAndInitializeCommunity(community);


        save(community);

        applicationEventPublisher.publish(communityCreatedEvent);
        return communityCreatedEvent;
    }

    private void save(Community community) {
        try {
            communityRepository.saveCommunity(community);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException("Erro ao persistir comunidade " + e.getMessage());
        }
    }
}
