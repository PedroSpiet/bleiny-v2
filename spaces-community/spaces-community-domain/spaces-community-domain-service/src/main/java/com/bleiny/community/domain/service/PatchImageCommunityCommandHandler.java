package com.bleiny.community.domain.service;

import com.bleiny.community.domain.service.dto.UpdateImageCommunityCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Slf4j
public class PatchImageCommunityCommandHandler {
    private final PatchImageCommunityHelper communityCommandHandler;

    public PatchImageCommunityCommandHandler(PatchImageCommunityHelper communityCommandHandler) {
        this.communityCommandHandler = communityCommandHandler;
    }


    public void handle(String uuid, MultipartFile file) {
        UpdateImageCommunityCommand command = UpdateImageCommunityCommand
                .builder()
                .multipartFile(file)
                .uuid(uuid)
                .build();

        try {
            communityCommandHandler.putImage(command);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new IllegalStateException("Error on update Community Image");
        }
    }
}
