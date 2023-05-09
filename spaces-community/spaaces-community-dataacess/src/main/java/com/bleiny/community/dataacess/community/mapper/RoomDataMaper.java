package com.bleiny.community.dataacess.community.mapper;

import com.bleiny.community.dataacess.community.entity.RoomEntity;
import com.bleiny.community.domain.core.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomDataMaper {
    private final CommunityDataMapper communityDataMapper;

    public RoomDataMaper(CommunityDataMapper communityDataMapper) {
        this.communityDataMapper = communityDataMapper;
    }

    public  RoomEntity roomToEntity(Room room) {
        return RoomEntity.builder()
                .roomName(room.getRoomName())
                .uuid(room.getId().toString())
                .isVoice(room.getIsVoice())
                .community(communityDataMapper.communityDtoToEntity(room.getCommunity()))
                .build();
    }
}
