package com.bleiny.community.domain.service;


import com.bleiny.community.domain.core.events.CommunityCreatedEvent;
import com.bleiny.community.domain.service.dto.CreateCommunityCommand;
import com.bleiny.community.domain.service.mapper.CommunityMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommunityCreateCommandHandler {

    private final CommunityCreateHelper helper;


    public CommunityCreateCommandHandler(CommunityCreateHelper helper) {
        this.helper = helper;
    }

    @Transactional
    public CommunityCreatedEvent  createCommunity(CreateCommunityCommand command) {
        return helper.persistCommunity(command);
    }
}
