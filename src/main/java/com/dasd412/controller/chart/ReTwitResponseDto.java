package com.dasd412.controller.chart;

import com.dasd412.domain.twit.ReTwit;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ReTwitResponseDto {

    private final String id;
    private final String body;
    private final String deleted;
    private final String worked;

    public ReTwitResponseDto(String id, String body, String deleted, String worked) {
        this.id = id;
        this.body = body;
        this.deleted = deleted;
        this.worked = worked;
    }

    public ReTwitResponseDto(ReTwit entity) {
        this.id = entity.getId();
        this.body = entity.getBody();
        this.deleted = entity.getDeleted();
        this.worked = entity.getWorked();
    }

    public ReTwit toEntity() {
        return new ReTwit.Builder()
            .id(id)
            .body(body)
            .deleted(deleted)
            .worked(worked)
            .build();
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getDeleted() {
        return deleted;
    }

    public String getWorked() {
        return worked;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", id)
            .append("body", body)
            .append("worked", worked)
            .append("deleted", deleted)
            .toString();
    }
}
