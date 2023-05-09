package com.bleiny.community.domain.service.ports.output.repository;

import com.bleiny.community.domain.core.entity.Community;
import com.bleiny.community.domain.core.entity.Tag;

public interface TagServerRepository {
    void addTagServer(Long tag, Long community);
}
