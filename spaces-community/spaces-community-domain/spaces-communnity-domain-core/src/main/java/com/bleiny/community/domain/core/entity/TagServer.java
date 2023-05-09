package com.bleiny.community.domain.core.entity;

import com.bleiny.commons.domain.valueobjects.BaseId;
import com.bleiny.commons.domain.valueobjects.CommunityId;
import com.bleiny.community.domain.core.valueobjects.TagServerId;

import java.util.List;
import java.util.UUID;

public class TagServer extends BaseId<TagServerId> {

    public TagServer(TagServerId value) {
        super(value);
    }

    private Tag tags;

    private Community communities;
}
