package com.bleiny.community.domain.service;

import com.bleiny.community.domain.service.dto.EnjoyCommunityCommand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EnjoyCommunityCommandHandler {
    private final EnjoyCommunityHelper communityHelper;

    public EnjoyCommunityCommandHandler(EnjoyCommunityHelper communityHelper) {
        this.communityHelper = communityHelper;
    }

    @Transactional
    public void enjoyHandler(EnjoyCommunityCommand command) throws Exception {
        communityHelper.enjoyCommunity(command);
    }
}
