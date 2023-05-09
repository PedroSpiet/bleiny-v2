package com.bleiny.community.application.rest;

import com.bleiny.community.domain.service.dto.CreateCommunityCommand;
import com.bleiny.community.domain.service.dto.CreateRoomCommand;
import com.bleiny.community.domain.service.dto.EnjoyCommunityCommand;
import com.bleiny.community.domain.service.ports.input.service.CommunityService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/community")
@Slf4j
public class CommunityController {

    private final CommunityService communityApplicationService;

    public CommunityController(CommunityService communityApplicationService) {
        this.communityApplicationService = communityApplicationService;
    }

    @PostMapping
    public ResponseEntity<?> createCommunity(@RequestBody CreateCommunityCommand command) {
        try {
            command.setMembersQuantity(1);
            communityApplicationService.createCommunity(command);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/enjoy")
    public ResponseEntity<?> enjoyCommunity(@RequestBody EnjoyCommunityCommand command) {
        try {
            communityApplicationService.enjoy(command);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/room")
    public ResponseEntity<?> createRoom(@RequestBody CreateRoomCommand command) {
        try {
            communityApplicationService.createRoom(command);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping(value = "/image/{uuid}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateImageCommunity(@PathVariable String uuid,
                                                  @RequestParam("file") MultipartFile file) {
        try {
            communityApplicationService.patchImage(uuid, file);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
