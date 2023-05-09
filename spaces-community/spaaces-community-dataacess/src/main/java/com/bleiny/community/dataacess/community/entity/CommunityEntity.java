package com.bleiny.community.dataacess.community.entity;

import com.bleiny.community.dataacess.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "community_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "community_uuid")
    private String communityUuid;

    @Column(name = "community_name")
    private String communityName;

    private String description;

    @Column(name = "community_image")
    private String communityImage;

    @OneToMany(mappedBy = "community")
    private List<TagServerEntity> tags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userCreator;

    @Column(name = "members_quantity")
    private Integer membersQuantity;

    @OneToMany(mappedBy = "community")
    private List<RoomEntity> rooms;

    @OneToMany(mappedBy = "community")
    private List<ServerMemberEntity> serverMembers;
}
