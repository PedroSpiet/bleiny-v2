package com.bleiny.community.dataacess.community.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room_table")
@Builder
public class RoomEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "is_voice")
    private Boolean isVoice;

    @ManyToOne
    private CommunityEntity community;
}