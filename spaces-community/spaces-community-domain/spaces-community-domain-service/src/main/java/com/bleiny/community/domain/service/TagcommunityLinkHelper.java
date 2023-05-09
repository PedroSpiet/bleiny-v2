package com.bleiny.community.domain.service;


import com.bleiny.community.domain.service.dto.TagServerVinculateCommand;
import com.bleiny.community.domain.service.ports.output.repository.TagServerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TagcommunityLinkHelper {

    private final TagServerRepository tagServerRepository;;

    public TagcommunityLinkHelper(TagServerRepository tagServerRepository) {
        this.tagServerRepository = tagServerRepository;
    }

    public void llinkCommunityTag(TagServerVinculateCommand command) throws Exception {
        try {
            tagServerRepository.addTagServer(command.getIdTag(), command.getIdCommunity());
        } catch (Exception e) {
            throw new Exception("Error on link community on tag " + e.getMessage());
        }
    }
}
