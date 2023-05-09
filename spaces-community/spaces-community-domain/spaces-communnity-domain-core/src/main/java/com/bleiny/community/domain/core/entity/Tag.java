package com.bleiny.community.domain.core.entity;

import com.bleiny.commons.domain.valueobjects.BaseId;
import com.bleiny.community.domain.core.valueobjects.TagId;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


public class Tag extends BaseId<TagId> {
    public Tag(TagId value) {
        super(value);
    }

    private Long tagId;
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public Long getTagId() {
        return tagId;
    }
}
