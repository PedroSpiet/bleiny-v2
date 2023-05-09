package com.bleiny.community.dataacess.community.mapper;

import com.bleiny.community.dataacess.community.entity.CommunityEntity;
import com.bleiny.community.dataacess.community.entity.TagEntity;
import com.bleiny.community.dataacess.community.entity.TagServerEntity;
import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.core.entity.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagServerDataMapper {

    private final CommunityDataMapper communityDataMapper;

    public TagServerDataMapper(CommunityDataMapper communityDataMapper) {
        this.communityDataMapper = communityDataMapper;
    }


    public TagServerEntity tagAndCommunityToTagServer(
            Long tag, Long community
    ) {
        return TagServerEntity.builder()
                .tag(TagEntity.builder()
                        .id(tag)
                        .build())
                .community(CommunityEntity.builder()
                        .id(community).build())
                .build();
    }

    public TagEntity tagToTagEntity(Tag tag) {
        return TagEntity
                .builder()
                .tagName(tag.getTagName())
                .build();
    }
}
