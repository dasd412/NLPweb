package com.dasd412.domain.twit;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;


//@Entity
public class Twit {// N , 리트윗과 다대일 관계

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Column(columnDefinition = "TEXT")
    private String body;

    private String hashtag;

    //@Column(columnDefinition = "TEXT")
    private String worked;

    //@Column(columnDefinition = "TEXT")
    private String deleted;

    private LocalDateTime date;

    private boolean isRetwitted;

    private String originId;

    private String keyWord;

//    @ManyToOne
//    @JoinColumn(name = "re_twit_id")
//    private ReTwit reTwit;


    protected Twit() {
    }

    public Twit(String body, String hashtag, String worked, String deleted, LocalDateTime date,
        boolean isRetwitted, String originId, String keyWord) {
        this.body = body;
        this.hashtag = hashtag;
        this.worked = worked;
        this.deleted = deleted;
        this.date = date;
        this.isRetwitted = isRetwitted;
        this.originId = originId;
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
            .append("deleted", deleted)
            .append("date", date)
            .append("is re_twit", isRetwitted)
            .append("origin_id", originId)
            .append("keyword", keyWord)
            .append("date", date)
            .toString();
    }


    public Long getId() {
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

    public boolean isRetwitted() {
        return isRetwitted;
    }

    public String getOriginId() {
        return originId;
    }

    public String getKeyWord() {
        return keyWord;
    }

//    public ReTwit getReTwit() {
//        return reTwit;
//    }
//
//    public void setReTwit(ReTwit reTwit) {
//        this.reTwit = reTwit;
//        //무한 루프 방지
//        if (!reTwit.getTwitList().contains(this)) {
//            reTwit.getTwitList().add(this);
//        }
//    }

    static public class Builder {

        private Long id;
        private String body;
        private String hashtag;
        private String worked;
        private String deleted;
        private LocalDateTime date;
        private boolean isRetwitted;
        private String originId;
        private String keyWord;

        public Builder() {
        }

        public Builder(Twit twit) {
            this.id = twit.id;
            this.body = twit.body;
            this.hashtag = twit.hashtag;
            this.worked = twit.worked;
            this.deleted = twit.deleted;
            this.date = twit.date;
            this.isRetwitted = twit.isRetwitted;
            this.originId = twit.originId;
            this.keyWord = twit.keyWord;
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

        public Builder deleted(String deleted) {
            checkArgument(deleted.length() > 0, "deleted length should be x>0");
            this.deleted = deleted;
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

        public Builder keyWord(String keyWord) {
            checkArgument(keyWord.length() > 0 && keyWord.length() <= 20,
                "keyWord length should be 20>=x>0");
            this.keyWord = keyWord;
            return this;
        }

        public Twit build() {
            return new Twit(body, hashtag, worked, deleted, date, isRetwitted, originId, keyWord);
        }

    }
}
