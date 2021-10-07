package com.dasd412.domain.twit;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
@Table(name = "retwit")
public class ReTwit {// 1 , 트윗과 일대다 관계

    @Id
    @Column(name = "origin_id", length = 20)
    private String id;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TEXT")
    private String special_deleted;

    @Column(columnDefinition = "TEXT")
    private String okt_pos;

    @Column(columnDefinition = "TEXT")
    private String stopwords_deleted;

    @Column(columnDefinition = "TEXT")
    private String noun;

    @Column(columnDefinition = "TEXT")
    private String n_v_adj_ad;


    protected ReTwit() {
    }

    public ReTwit(String id, String body, String special_deleted, String okt_pos,
        String stopwords_deleted, String noun, String n_v_adj_ad) {
        this.id = id;
        this.body = body;
        this.special_deleted = special_deleted;
        this.okt_pos = okt_pos;
        this.stopwords_deleted = stopwords_deleted;
        this.noun = noun;
        this.n_v_adj_ad = n_v_adj_ad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReTwit reTwit = (ReTwit) obj;
        return Objects.equals(this.id, reTwit.id);
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

    static public class Builder {

        private String id;
        private String body;
        private String special_deleted;
        private String okt_pos;
        private String stopwords_deleted;
        private String noun;
        private String n_v_adj_ad;


        public Builder() {
        }

        public Builder(ReTwit reTwit) {
            this.id = reTwit.id;
            this.body = reTwit.body;
            this.special_deleted = reTwit.special_deleted;
            this.okt_pos = reTwit.okt_pos;
            this.stopwords_deleted = reTwit.stopwords_deleted;
            this.noun = reTwit.noun;
            this.n_v_adj_ad = reTwit.n_v_adj_ad;
        }

        public Builder id(String id) {
            checkArgument(id.length() > 0 && id.length() <= 20, "id length should be 20>=x>0");
            this.id = id;
            return this;
        }

        public Builder body(String body) {
            checkArgument(body.length() > 0, "body length should be x>0");
            this.body = body;
            return this;
        }

        public Builder special_deleted(String special_deleted) {
            this.special_deleted = special_deleted;
            return this;
        }

        public Builder okt_pos(String okt_pos) {
            this.okt_pos = okt_pos;
            return this;
        }

        public Builder stopwords_deleted(String stopwords_deleted) {
            this.stopwords_deleted = stopwords_deleted;
            return this;
        }

        public Builder noun(String noun) {
            this.noun = noun;
            return this;
        }

        public Builder n_v_adj_ad(String n_v_adj_ad) {
            this.n_v_adj_ad = n_v_adj_ad;
            return this;
        }

        public ReTwit build() {
            return new ReTwit(id, body, special_deleted, okt_pos, stopwords_deleted, noun,
                n_v_adj_ad);
        }
    }
}
