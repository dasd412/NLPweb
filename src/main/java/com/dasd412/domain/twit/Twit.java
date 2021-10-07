package com.dasd412.domain.twit;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;


@Entity
@Table(name = "twit")
public class Twit {// N , 리트윗과 다대일 관계

    @Id
    @Column(name = "twit_Index", length = 20)
    private String id;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(length = 100)
    private String hashtag;

    @Column(columnDefinition = "TEXT")
    private String worked;

    private LocalDateTime date;

    @Column(name = "is_retwitted")
    private boolean isRetwitted;

    @Column(name = "origin_id", length = 20)
    private String originId;

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

    protected Twit() {
    }

    public Twit(String id, String body, String hashtag, String worked, LocalDateTime date,
        boolean isRetwitted, String originId, String special_deleted, String okt_pos,
        String stopwords_deleted, String noun, String n_v_adj_ad) {
        this.id = id;
        this.body = body;
        this.hashtag = hashtag;
        this.worked = worked;
        this.date = date;
        this.isRetwitted = isRetwitted;
        this.originId = originId;
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
        Twit twit = (Twit) obj;
        return Objects.equals(this.id, twit.id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", id)
            .append("body", body)
            .append("hashtag", hashtag)
            .append("worked", worked)
            .append("date", date)
            .append("is re_twit", isRetwitted)
            .append("origin_id", originId)
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

    public String getHashtag() {
        return hashtag;
    }

    public String getWorked() {
        return worked;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isRetwitted() {
        return isRetwitted;
    }

    public String getOriginId() {
        return originId;
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
        private String hashtag;
        private String worked;
        private LocalDateTime date;
        private boolean isRetwitted;
        private String originId;
        private String special_deleted;
        private String okt_pos;
        private String stopwords_deleted;
        private String noun;
        private String n_v_adj_ad;


        public Builder() {
        }

        public Builder(Twit twit) {
            this.id = twit.id;
            this.body = twit.body;
            this.hashtag = twit.hashtag;
            this.worked = twit.worked;
            this.date = twit.date;
            this.isRetwitted = twit.isRetwitted;
            this.originId = twit.originId;
            this.special_deleted = twit.special_deleted;
            this.okt_pos = twit.okt_pos;
            this.stopwords_deleted = twit.stopwords_deleted;
            this.noun = twit.noun;
            this.n_v_adj_ad = twit.n_v_adj_ad;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder body(String body) {
            checkArgument(body.length() > 0, "body length should be x>0");
            this.body = body;
            return this;
        }

        public Builder hashtag(String hashtag) {
            checkArgument(hashtag.length() > 0 && hashtag.length() <= 100,
                "hashtag length should be 100>=x>0");
            this.hashtag = hashtag;
            return this;
        }

        public Builder worked(String worked) {
            checkArgument(worked.length() > 0, "worked length should be x>0");
            this.worked = worked;
            return this;
        }


        public Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Builder isRe_twitted(boolean isRetwitted) {
            this.isRetwitted = isRetwitted;
            return this;
        }

        public Builder originId(String originId) {
            checkArgument(originId.length() > 0 && originId.length() <= 20,
                "originId length should be 20>=x>0");
            this.originId = originId;
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

        public Twit build() {
            return new Twit(id, body, hashtag, worked, date, isRetwitted, originId, special_deleted,
                okt_pos, stopwords_deleted, noun,
                n_v_adj_ad);
        }

    }
}
