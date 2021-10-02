package com.dasd412.domain.tweet;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
public class ReTwit {//트윗과 다대다 관계

    @Id
    private String id;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TEXT")
    private String worked;

    @Column(columnDefinition = "TEXT")
    private String deleted;

    private String keyWord;

    protected ReTwit() {
    }

    public ReTwit(String id,String body, String worked, String deleted, String keyWord) {
        this.id=id;
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

        private String id;
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
            return new ReTwit(id,body, worked, deleted, keyWord);
        }
    }
}
