package com.bleiny.community.domain.service;

import com.bleiny.community.domain.service.dto.TagServerVinculateCommand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TagCommunityCommandHandler {

    private final TagcommunityLinkHelper tagcommunityLinkHelper;

    public TagCommunityCommandHandler(TagcommunityLinkHelper tagcommunityLinkHelper) {
        this.tagcommunityLinkHelper = tagcommunityLinkHelper;
    }

    @Transactional
    public void link(TagServerVinculateCommand command) throws Exception {
        tagcommunityLinkHelper.llinkCommunityTag(command);
    }
}
