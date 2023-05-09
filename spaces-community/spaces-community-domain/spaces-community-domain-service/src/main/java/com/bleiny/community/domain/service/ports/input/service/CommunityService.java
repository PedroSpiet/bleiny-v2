package com.bleiny.community.domain.service.ports.input.service;

import com.bleiny.community.domain.service.dto.CreateCommunityCommand;
import com.bleiny.community.domain.service.dto.CreateRoomCommand;
import com.bleiny.community.domain.service.dto.EnjoyCommunityCommand;
import com.bleiny.community.domain.service.dto.TagServerVinculateCommand;

public interface CommunityService {
    public void createCommunity(CreateCommunityCommand command);

    void linkTag(TagServerVinculateCommand command) throws Exception;

    void enjoy(EnjoyCommunityCommand command) throws Exception;

    void createRoom(CreateRoomCommand command);
}
