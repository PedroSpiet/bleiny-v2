package com.bleiny.domain.service;


import com.bleiny.commons.domain.valueobjects.UserId;
import com.bleiny.domain.core.UsersDomainService;
import com.bleiny.domain.core.aws.data.s3.FileStore;
import com.bleiny.domain.core.entity.User;
import com.bleiny.domain.service.dto.patch.PatchImageProfileCommand;
import com.bleiny.domain.service.mapper.UserDataMapper;
import com.bleiny.domain.service.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Component
@Slf4j
public class UserPatchProfileImageHelper {

    private final UsersDomainService usersDomainService;
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;

    private final static String BUCKET_NAME = "logo-image-users-teste";

    private final FileStore fileStore;

    public UserPatchProfileImageHelper(UsersDomainService usersDomainService, UserDataMapper userDataMapper, UserRepository userRepository, FileStore fileStore) {
        this.usersDomainService = usersDomainService;
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.fileStore = fileStore;
    }

    public void putImage(PatchImageProfileCommand command) throws Exception {
        // 1. Check if image is not empty
        isFileEmpty(command.getMultipartFile());
        // 2. If file is an image
        isImage(command.getMultipartFile());
        String oldPath;

        User user = findUserByUuid(command.getUserId());

        if (user.getImage() != null) {
            oldPath = user.getImage();
        }

        String path = String.format("%s/%s",  BUCKET_NAME, command.getUserId());
        String filename = String.format("%s-%s", command.getMultipartFile().getOriginalFilename(), UUID.randomUUID());

        Map<String, String> metadata = extractMetadata(command.getMultipartFile());

        fileStore.save(path, filename, Optional.of(metadata), command.getMultipartFile().getInputStream());
        //Update User table with the new image

        findUserByUuidAndUpdateProfileImage(command.getUserId(), filename);


        //Remove old image from S3
        // TODO fileStore.remove(BUCKET_NAME, oldPath);
    }

    public User findUserByUuid(String userId) {
        return userRepository.findByUuid(userId)
                .orElseThrow(() -> new IllegalStateException("Invalid User"));
    }

    public void findUserByUuidAndUpdateProfileImage(String uuid, String filename) throws Exception {
        try  {
            userRepository.findAndUpdateImageProfile(uuid, filename);
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

    public void isImage(MultipartFile file) {
        if (!Arrays.asList(
                IMAGE_JPEG.getMimeType(),
                IMAGE_PNG.getMimeType(),
                IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
        }
    }

    public void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
        }
    }
}
