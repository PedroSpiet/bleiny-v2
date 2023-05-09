package com.bleiny.community.domain.service.dto;


import com.bleiny.commons.domain.valueobjects.UserId;
import com.bleiny.community.domain.core.entity.Tag;
import com.bleiny.community.domain.core.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CreateCommunityCommand {
    @NotNull
    private final String communityName;
    @NotNull
    private final String description;
    private final List<Tag> tags;

    private final User userCreator;
    private  Integer membersQuantity;
}
