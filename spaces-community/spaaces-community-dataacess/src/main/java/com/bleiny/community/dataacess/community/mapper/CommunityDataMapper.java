package com.bleiny.community.dataacess.community.mapper;

import com.bleiny.commons.domain.valueobjects.CommunityId;
import com.bleiny.community.dataacess.community.entity.CommunityEntity;
import com.bleiny.community.dataacess.community.entity.RoomEntity;
import com.bleiny.community.dataacess.community.entity.TagEntity;
import com.bleiny.community.dataacess.community.entity.TagServerEntity;
import com.bleiny.community.dataacess.user.mapper.UserMapper;
import com.bleiny.community.domain.core.dto.CommunityDto;
import com.bleiny.community.domain.core.entity.Community;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CommunityDataMapper {

    private final ModelMapper mapper;

    public CommunityDataMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CommunityEntity communityToEntity(Community community) {
        return CommunityEntity
                .builder()
                .communityName(community.getCommunityName())
                .communityUuid(community.getId().getValue().toString())
                .description(community.getDescription())
                .userCreator(UserMapper.userToEntity(community.getUserCreator())).build();


    }

    public Community entityToCommunity(CommunityEntity community) {
         Community com = Community
                .builder()
                .communityName(community.getCommunityName())
                .description(community.getDescription())
                .membersQuantity(community.getMembersQuantity())
                .communityName(community.getCommunityName())
                 .userCreator(UserMapper.EntitytoUser(community.getUserCreator()))
                .build();

         com.setId(new CommunityId(UUID.fromString(community.getCommunityUuid())));

         return com;
    }

    public CommunityEntity communityDtoToEntity(CommunityDto community) {
        return CommunityEntity
                .builder()
                .communityName(community.getCommunityName())
                .communityUuid(community.getUuid())
                .description(community.getDescription())
                .id(community.getId()).build();

    }
}
