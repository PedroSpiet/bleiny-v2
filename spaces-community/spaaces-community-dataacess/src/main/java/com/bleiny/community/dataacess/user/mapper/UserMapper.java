package com.bleiny.community.dataacess.user.mapper;


import com.bleiny.community.dataacess.community.entity.CommunityEntity;
import com.bleiny.community.dataacess.community.entity.TagEntity;
import com.bleiny.community.dataacess.community.entity.TagServerEntity;
import com.bleiny.community.dataacess.user.UserEntity;
import com.bleiny.community.domain.core.entity.Tag;
import com.bleiny.community.domain.core.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    public static UserEntity userToEntity(User user) {
        UserEntity userEntity =
                UserEntity.builder()
                        .userUuid(user.getUserUuid())
                        .bio(user.getBio())
                        .image(user.getImage())
                        .username(user.getUsername())
                        .id(user.getId())
                        .build();

        if (user.getCommunity() != null) {
            userEntity.getCommunity().addAll(user.getCommunity()
                    .stream()
                    .map(x -> {
                        return CommunityEntity.builder()
                                .communityUuid(x.getId().getValue().toString())
                                .description(x.getDescription())
                                .communityName(x.getCommunityName())
                                .build();
                    }).toList());
        }


        return userEntity;
    }

    public static User EntitytoUser(UserEntity userEntity) {
        User user =
                User.builder()
                        .userUuid(userEntity.getUserUuid())
                        .bio(userEntity.getBio())
                        .image(userEntity.getImage())
                        .username(userEntity.getUsername())
                        .id(userEntity.getId())
                        .build();

        if (user.getCommunity() != null) {
            userEntity.getCommunity().addAll(user.getCommunity()
                    .stream()
                    .map(x -> CommunityEntity.builder()
                            .communityUuid(x.getId().getValue().toString())
                            .description(x.getDescription())
                            .communityName(x.getCommunityName())
                            .build()).toList());
        }


        return user;
    }
}
