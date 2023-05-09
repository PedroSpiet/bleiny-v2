package com.bleiny.community.domain.service;

import com.bleiny.community.domain.core.data.s3.FileStore;
import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.service.dto.UpdateImageCommunityCommand;
import com.bleiny.community.domain.service.ports.output.repository.CommunityRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Component
public class PatchImageCommunityHelper {

    private final CommunityRepository communityRepository;
    private final FileStore fileStore;
    private final static String BUCKET_NAME = "logo-community-teste";

    public PatchImageCommunityHelper(CommunityRepository communityRepository, FileStore fileStore) {
        this.communityRepository = communityRepository;
        this.fileStore = fileStore;
    }

    public void putImage(UpdateImageCommunityCommand command) throws Exception {
        // 1. Check if image is not empty
        isFileEmpty(command.getMultipartFile());
        // 2. If file is an image
        isImage(command.getMultipartFile());
        String oldPath;

        Community community = findCommunityByUuid(command.getUuid());

        if (community.getCommunityImage() != null) {
            oldPath = community.getCommunityImage();
        }

        String path = String.format("%s/%s", BUCKET_NAME, command.getUuid());
        String filename = String.format("%s-%s", command.getMultipartFile().getOriginalFilename(), UUID.randomUUID());

        Map<String, String> metadata = extractMetadata(command.getMultipartFile());

        fileStore.save(path, filename, Optional.of(metadata), command.getMultipartFile().getInputStream());
        //Update User table with the new image

        findByCommunityUuidAndUpdateImage(command.getUuid(), filename);


        //Remove old image from S3
        // TODO fileStore.remove(BUCKET_NAME, oldPath);
    }

    private Community findCommunityByUuid(String communityUuid) {
        return communityRepository.findByUuid(communityUuid);
    }

    private void findByCommunityUuidAndUpdateImage(String uuid, String filename) throws Exception {
        try {
            communityRepository.findAndUpdateImage(uuid, filename);
        } catch (Exception e) {
            throw new Exception("Error on update user profile " + e.getMessage());
        }
    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private void isImage(MultipartFile file) {
        if (!Arrays.asList(
                IMAGE_JPEG.getMimeType(),
                IMAGE_PNG.getMimeType(),
                IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
        }
    }
}

