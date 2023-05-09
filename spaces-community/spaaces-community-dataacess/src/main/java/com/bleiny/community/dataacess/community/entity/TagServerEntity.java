package com.bleiny.community.dataacess.community.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tag_server_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagServerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CommunityEntity community;

    @ManyToOne
    private TagEntity tag;
}
