package com.bleiny.community.domain.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagServerVinculateCommand {
    private Long  idCommunity;
    private Long idTag;
}
