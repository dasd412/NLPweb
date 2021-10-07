package com.dasd412.controller.nlp;

import com.dasd412.domain.twit.ReTwit;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ReTwitResponseDto {

    private final String id;
    private final String body;
    private final String special_deleted;
    private final String okt_pos;
    private final String stopwords_deleted;
    private final String noun;
    private final String n_v_adj_ad;

    public ReTwitResponseDto(String id, String body, String special_deleted, String okt_pos,
        String stopwords_deleted, String noun, String n_v_adj_ad) {
        this.id = id;
        this.body = body;
        this.special_deleted = special_deleted;
        this.okt_pos = okt_pos;
        this.stopwords_deleted = stopwords_deleted;
        this.noun = noun;
        this.n_v_adj_ad = n_v_adj_ad;
    }

    public ReTwitResponseDto(ReTwit entity) {
        this.id = entity.getId();
        this.body = entity.getBody();
        this.special_deleted = entity.getSpecial_deleted();
        this.okt_pos = entity.getOkt_pos();
        this.stopwords_deleted = entity.getStopwords_deleted();
        this.noun = entity.getNoun();
        this.n_v_adj_ad = entity.getN_v_adj_ad();
    }

    public ReTwit toEntity() {
        return new ReTwit.Builder()
            .id(id)
            .body(body)
            .special_deleted(special_deleted)
            .okt_pos(okt_pos)
            .stopwords_deleted(stopwords_deleted)
            .noun(noun)
            .n_v_adj_ad(n_v_adj_ad)
            .build();
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getSpecial_deleted() {
        return special_deleted;
    }

    public String getOkt_pos() {
        return okt_pos;
    }

    public String getStopwords_deleted() {
        return stopwords_deleted;
    }

    public String getNoun() {
        return noun;
    }

    public String getN_v_adj_ad() {
        return n_v_adj_ad;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", id)
            .append("body", body)
            .append("special_deleted", special_deleted)
            .append("okt_pos", okt_pos)
            .append("stopwords_deleted", stopwords_deleted)
            .append("noun", noun)
            .append("n_v_adj_ad", n_v_adj_ad)
            .toString();
    }
}
