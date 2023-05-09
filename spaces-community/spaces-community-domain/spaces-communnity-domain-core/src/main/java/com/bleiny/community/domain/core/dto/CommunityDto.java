package com.bleiny.community.domain.core.dto;

import com.bleiny.community.domain.core.entity.Roles;
import com.bleiny.community.domain.core.entity.Room;
import com.bleiny.community.domain.core.entity.Tag;
import com.bleiny.community.domain.core.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommunityDto {

    private final Long id;
    private final String communityName;
    private final String description;
    private final List<Tag> tags;
    private final String uuid;
    private final User userCreator;

    private final List<Roles> roles;

    private Integer membersQuantity;

    public void setMembersQuantity(Integer membersQuantity) {
        this.membersQuantity = membersQuantity;
    }

    private final List<Room> rooms;

    public CommunityDto(Long id, String communityName, String description, List<Tag> tags, String uuid, User userCreator, List<Roles> roles, Integer membersQuantity, List<Room> rooms) {
        this.id = id;
        this.communityName = communityName;
        this.description = description;
        this.tags = tags;
        this.uuid = uuid;
        this.userCreator = userCreator;
        this.roles = roles;
        this.membersQuantity = membersQuantity;
        this.rooms = rooms;
    }
}
