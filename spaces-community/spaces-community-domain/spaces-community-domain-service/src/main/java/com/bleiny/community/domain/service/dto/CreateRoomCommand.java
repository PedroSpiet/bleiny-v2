package com.bleiny.community.domain.service.dto;

import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.core.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateRoomCommand {
    private Room room;
}
