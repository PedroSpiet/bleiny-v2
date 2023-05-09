package com.bleiny.community.application.rest;

import com.bleiny.community.domain.service.dto.CreateCommunityCommand;
import com.bleiny.community.domain.service.dto.CreateRoomCommand;
import com.bleiny.community.domain.service.dto.EnjoyCommunityCommand;
import com.bleiny.community.domain.service.ports.input.service.CommunityService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
