package com.dasd412.domain.tweet;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
public class ReTwit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    private String worked;

    private String deleted;

    private String keyWord;

    protected ReTwit() {
    }

    public ReTwit(String body, String worked, String deleted, String keyWord) {
        this.body = body;
        this.worked = worked;
        this.deleted = deleted;
        this.keyWord = keyWord;
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
            .append("worked", worked)
            .append("deleted", deleted)
            .append("keyword", keyWord)
            .toString();
    }

    static public class Builder {

        private Long id;
        private String body;
        private String worked;
        private String deleted;
        private String keyWord;

        public Builder() {
        }

        public Builder(ReTwit reTwit) {
            this.id = reTwit.id;
            this.body = reTwit.body;
            this.worked = reTwit.worked;
            this.deleted = reTwit.deleted;
            this.keyWord = reTwit.keyWord;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder body(String body) {
            checkArgument(body.length() > 0, "body length should be x>0");
            this.body = body;
            return this;
        }

        public Builder worked(String worked) {
            checkArgument(worked.length() > 0, "worked length should be x>0");
            this.worked = worked;
            return this;
        }

        public Builder deleted(String deleted) {
            checkArgument(deleted.length() > 0, "deleted length should be x>0");
            this.deleted = deleted;
            return this;
        }

        public Builder keyWord(String keyWord) {
            checkArgument(keyWord.length() > 0 && keyWord.length() <= 20,
                "keyWord length should be 20>=x>0");
            this.keyWord = keyWord;
            return this;
        }

        public ReTwit build() {
            return new ReTwit(body, worked, deleted, keyWord);
        }
    }
}
