package com.bleiny.community.dataacess.community.entity;

import com.bleiny.community.dataacess.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_server_member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServerMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_community")
   private CommunityEntity community;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;
}
