package com.bleiny.community.application.rest;

import com.bleiny.community.domain.service.dto.TagServerVinculateCommand;
import com.bleiny.community.domain.service.ports.input.service.CommunityService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tags")
@Slf4j
public class TagController {

    private final CommunityService communityApplicationService;

    public TagController(CommunityService communityApplicationService) {
        this.communityApplicationService = communityApplicationService;
    }

    @PostMapping
    public ResponseEntity<?> linkCommunityTag(@Valid @RequestBody TagServerVinculateCommand command) {
        try {
            communityApplicationService.linkTag(command);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
