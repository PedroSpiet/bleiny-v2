package com.bleiny.community.dataacess.user;

import com.bleiny.community.dataacess.community.entity.CommunityEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_uuid")
    private String userUuid;
    private String image;
    private String username;
    private String bio;

    @OneToMany
    private List<CommunityEntity> community;
}

