package com.bleiny.community.domain.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UpdateImageCommunityCommand {
    private String uuid;
    private MultipartFile multipartFile;
}
