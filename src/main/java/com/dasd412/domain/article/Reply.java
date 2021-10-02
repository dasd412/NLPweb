package com.dasd412.domain.article;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
public class Reply {//Article과 다대일 관계
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String keyWord;

    private LocalDateTime date;

    protected Reply() {
    }

    public Reply(String text, String keyWord, LocalDateTime date) {
        this.text = text;
        this.keyWord = keyWord;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public LocalDateTime getDate() {
        return date;
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
            .append("text", text)
            .append("keyword", keyWord)
            .append("date", date)
            .toString();
    }

    static public class Builder {

        private Long id;
        private String text;
        private String keyWord;
        private LocalDateTime date;

        public Builder() {
        }

        public Builder(Reply reply) {
            this.id = reply.id;
            this.text = reply.text;
            this.keyWord = reply.keyWord;
            this.date = reply.date;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
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

        public Reply build() {
            return new Reply(text, keyWord, date);
        }
    }

}
