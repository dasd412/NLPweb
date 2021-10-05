package com.dasd412.domain.article;

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
@Table(name = "reply")
public class Reply {
    @Id
    @Column(name = "article_Index")
    private String id;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(name = "keyword", length = 20)
    private String keyWord;

    private LocalDateTime date;

    @Column(columnDefinition = "TEXT")
    private String worked;


    protected Reply() {
    }

    public Reply(String body, String keyWord, LocalDateTime date, String worked) {
        this.body = body;
        this.keyWord = keyWord;
        this.date = date;
        this.worked = worked;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getWorked() {
        return worked;
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
            .append("id", id)
            .append("body", body)
            .append("keyword", keyWord)
            .append("date", date)
            .append("worked", worked)
            .toString();
    }

    static public class Builder {

        private String id;
        private String body;
        private String keyWord;
        private LocalDateTime date;
        private String worked;

        public Builder() {
        }

        public Builder(Reply reply) {
            this.id = reply.id;
            this.body = reply.body;
            this.keyWord = reply.keyWord;
            this.date = reply.date;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder keyWord(String keyWord) {
            checkArgument(keyWord.length() > 0 && keyWord.length() <= 20,
                "keyword length should be 0<x<=20");
            this.keyWord = keyWord;
            return this;
        }

        public Builder dateTime(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Builder worked(String worked) {
            this.worked = worked;
            return this;
        }

        public Reply build() {
            return new Reply(body, keyWord, date, worked);
        }
    }

}
