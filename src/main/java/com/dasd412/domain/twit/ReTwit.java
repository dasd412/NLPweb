package com.dasd412.domain.twit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
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
    private String deleted;

    @Column(columnDefinition = "TEXT")
    private String worked;


    protected ReTwit() {
    }

    public ReTwit(String id, String body, String worked, String deleted) {
        this.id = id;
        this.body = body;
        this.worked = worked;
        this.deleted = deleted;
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
            .toString();
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getWorked() {
        return worked;
    }

    public String getDeleted() {
        return deleted;
    }

    static public class Builder {

        private String id;
        private String body;
        private String worked;
        private String deleted;

        public Builder() {
        }

        public Builder(ReTwit reTwit) {
            this.id = reTwit.id;
            this.body = reTwit.body;
            this.worked = reTwit.worked;
            this.deleted = reTwit.deleted;
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

        public ReTwit build() {
            return new ReTwit(id, body, worked, deleted);
        }
    }
}
