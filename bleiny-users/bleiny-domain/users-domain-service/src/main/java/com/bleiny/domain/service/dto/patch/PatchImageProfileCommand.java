package com.bleiny.domain.service.dto.patch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatchImageProfileCommand {
    private String userId;
    private MultipartFile multipartFile;
}
