package com.dasd412.controller.chart;

import com.dasd412.domain.twit.Twit;
import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TwitResponseDto {

    private final String id;
    private final String body;
    private final String hashtag;
    private final String worked;
    private final String deleted;
    private final LocalDateTime date;
    private final boolean is_reTwitted;
    private final String origin_id;

    public TwitResponseDto(String id, String body, String hashtag, String worked, String deleted,
        LocalDateTime date, boolean is_reTwitted, String origin_id) {
        this.id = id;
        this.body = body;
        this.hashtag = hashtag;
        this.worked = worked;
        this.deleted = deleted;
        this.date = date;
        this.is_reTwitted = is_reTwitted;
        this.origin_id = origin_id;
    }

    public TwitResponseDto(Twit entity) {
        this.id = entity.getId();
        this.body = entity.getBody();
        this.hashtag = entity.getHashtag();
        this.worked = entity.getWorked();
        this.deleted = entity.getDeleted();
        this.date = entity.getDate();
        this.is_reTwitted = entity.isRetwitted();
        this.origin_id = entity.getOriginId();
    }

    public Twit toEntity() {
        return new Twit.Builder()
            .id(id)
            .body(body)
            .hashtag(hashtag)
            .worked(worked)
            .deleted(deleted)
            .originId(origin_id)
            .isRe_twitted(is_reTwitted)
            .date(date)
            .build();
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getWorked() {
        return worked;
    }

    public String getDeleted() {
        return deleted;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isIs_reTwitted() {
        return is_reTwitted;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", id)
            .append("body", body)
            .append("worked", worked)
            .append("deleted", deleted)
            .append("date", date)
            .append("is_re_twit", is_reTwitted)
            .toString();
    }


}
