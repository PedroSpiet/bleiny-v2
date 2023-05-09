package com.bleiny.community.domain.service.mapper;

import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.service.dto.CreateCommunityCommand;
import org.springframework.stereotype.Component;

@Component
public class CommunityMapper {
    public Community CreateCommunityCommandToCommunity(CreateCommunityCommand command) {
        return Community
                .builder()
                .userCreator(command.getUserCreator())
                .communityName(command.getCommunityName())
                .description(command.getDescription())
                .userCreator(command.getUserCreator())
                .build();
    }

}
