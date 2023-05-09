package com.bleiny.community.dataacess.community.adapter;

import com.bleiny.community.dataacess.community.entity.TagServerEntity;
import com.bleiny.community.dataacess.community.mapper.TagServerDataMapper;
import com.bleiny.community.dataacess.community.repository.TagServerJpaRepository;
import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.core.entity.Tag;
import com.bleiny.community.domain.service.ports.output.repository.TagServerRepository;
import org.springframework.stereotype.Component;

@Component
public class TagServerRepositoryImpl implements TagServerRepository {

    private final TagServerDataMapper tagServerDataMapper;

    private final TagServerJpaRepository tagServerJpaRepository;

    public TagServerRepositoryImpl(TagServerDataMapper tagServerDataMapper, TagServerJpaRepository tagServerJpaRepository) {
        this.tagServerDataMapper = tagServerDataMapper;
        this.tagServerJpaRepository = tagServerJpaRepository;
    }

    @Override
    public void addTagServer(Long tag, Long community) {
        TagServerEntity converted =
                tagServerDataMapper.
                        tagAndCommunityToTagServer(tag, community);

        tagServerJpaRepository.save(converted);
    }
}