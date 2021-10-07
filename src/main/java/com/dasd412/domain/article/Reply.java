package com.dasd412.domain.article;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name = "reply")
public class Reply {

    @Id
    @Column(name = "article_Index")
    private String id;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime date;

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

    protected Reply() {
    }

    public Reply(String id, String body, LocalDateTime date, String special_deleted,
        String okt_pos, String stopwords_deleted, String noun, String n_v_adj_ad) {
        this.id = id;
        this.body = body;
        this.date = date;
        this.special_deleted = special_deleted;
        this.okt_pos = okt_pos;
        this.stopwords_deleted = stopwords_deleted;
        this.noun = noun;
        this.n_v_adj_ad = n_v_adj_ad;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getDate() {
        return date;
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
        Reply reply = (Reply) obj;
        return Objects.equals(this.id, reply.id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("article_Index", id)
            .append("body", body)
            .append("date", date)
            .append("special_deleted", special_deleted)
            .append("okt_pos", okt_pos)
            .append("stopwords_deleted", stopwords_deleted)
            .append("noun", noun)
            .append("n_v_adj_ad", n_v_adj_ad)
            .toString();
    }

    static public class Builder {

        private String id;
        private String body;
        private LocalDateTime date;
        private String special_deleted;
        private String okt_pos;
        private String stopwords_deleted;
        private String noun;
        private String n_v_adj_ad;

        public Builder() {
        }

        public Builder(Reply reply) {
            this.id = reply.id;
            this.body = reply.body;
            this.date = reply.date;
            this.special_deleted = reply.special_deleted;
            this.okt_pos = reply.okt_pos;
            this.stopwords_deleted = reply.stopwords_deleted;
            this.noun = reply.noun;
            this.n_v_adj_ad = reply.n_v_adj_ad;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }


        public Builder dateTime(LocalDateTime date) {
            this.date = date;
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

        public Reply build() {
            return new Reply(id, body, date, special_deleted,
                okt_pos, stopwords_deleted, noun, n_v_adj_ad);
        }
    }

}
