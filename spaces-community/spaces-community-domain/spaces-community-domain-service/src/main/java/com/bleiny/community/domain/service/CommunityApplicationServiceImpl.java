package com.bleiny.community.domain.service;

import com.bleiny.community.domain.service.dto.CreateCommunityCommand;
import com.bleiny.community.domain.service.dto.CreateRoomCommand;
import com.bleiny.community.domain.service.dto.EnjoyCommunityCommand;
import com.bleiny.community.domain.service.dto.TagServerVinculateCommand;
import com.bleiny.community.domain.service.ports.input.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommunityApplicationServiceImpl implements CommunityService {
    private final CommunityCreateCommandHandler communityCreateCommandHandler;

    private final TagCommunityCommandHandler tagCommunityCommandHandler;

    private final EnjoyCommunityCommandHandler enjoyCommunityCommandHandler;

    private final CreateRoomComandHandler createRoomComandHandler;

    public CommunityApplicationServiceImpl(CommunityCreateCommandHandler communityCreateCommandHandler, TagCommunityCommandHandler communityCommandHandler, EnjoyCommunityCommandHandler enjoyCommunityCommandHandler, CreateRoomComandHandler createRoomComandHandler) {
        this.communityCreateCommandHandler = communityCreateCommandHandler;
        this.tagCommunityCommandHandler = communityCommandHandler;
        this.enjoyCommunityCommandHandler = enjoyCommunityCommandHandler;
        this.createRoomComandHandler = createRoomComandHandler;
    }

    @Override
    public void createCommunity(CreateCommunityCommand command) {
        communityCreateCommandHandler.createCommunity(command);
    }

    @Override
    public void linkTag(TagServerVinculateCommand command) throws Exception {
        tagCommunityCommandHandler.link(command);
    }

    @Override
    public void enjoy(EnjoyCommunityCommand command) throws Exception {
        enjoyCommunityCommandHandler.enjoyHandler(command);
    }

    @Override
    public void createRoom(CreateRoomCommand command) {
        createRoomComandHandler.handle(command);
    }
}
