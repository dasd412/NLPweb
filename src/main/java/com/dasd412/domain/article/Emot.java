package com.dasd412.domain.article;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
@Table(name = "emot")
public class Emot {//기사와 다대일 관계

    @Id
    @Column(name = "article_Index", length = 768)
    private String article_Index;

    private int likes;

    private int warm;

    private int sad;

    private int mad;

    private int want;

    protected Emot() {
    }

    public Emot(String article_Index, int likes, int warm, int sad, int mad, int want) {
        this.article_Index = article_Index;
        this.likes = likes;
        this.warm = warm;
        this.sad = sad;
        this.mad = mad;
        this.want = want;
    }

    public String getArticle_Index() {
        return article_Index;
    }

    public int getLikes() {
        return likes;
    }

    public int getWarm() {
        return warm;
    }

    public int getSad() {
        return sad;
    }

    public int getMad() {
        return mad;
    }

    public int getWant() {
        return want;
    }


    @Override
    public int hashCode() {
        return Objects.hash(article_Index);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Emot emot = (Emot) obj;
        return Objects.equals(this.article_Index, emot.article_Index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("article_Index", article_Index)
            .append("likes", likes)
            .append("warm", warm)
            .append("sad", sad)
            .append("mad", mad)
            .append("want", want)
            .toString();
    }


    static public class Builder {

        private String article_Index;
        private int likes;
        private int warm;
        private int sad;
        private int mad;
        private int want;

        public Builder() {
        }

        public Builder(Emot emot) {
            this.article_Index = emot.article_Index;
            this.likes = emot.likes;
            this.warm = emot.warm;
            this.sad = emot.sad;
            this.mad = emot.mad;
            this.want = emot.want;
        }

        public Builder articleIndex(String article_Index) {
            checkArgument(article_Index.length() > 0 && article_Index.length() <= 768,
                "article_Index length should be 768>=x>0");
            this.article_Index = article_Index;
            return this;
        }

        public Builder likes(int likes) {
            checkArgument(likes >= 0, "likes should be x>=0");
            this.likes = likes;
            return this;
        }


        public Builder warm(int warm) {
            checkArgument(warm >= 0, "warm should be x>=0");
            this.warm = warm;
            return this;
        }

        public Builder sad(int sad) {
            checkArgument(sad >= 0, "sad should be x>=0");
            this.sad = sad;
            return this;
        }

        public Builder mad(int mad) {
            checkArgument(mad >= 0, "mad should be x>=0");
            this.mad = mad;
            return this;
        }

        public Builder want(int want) {
            checkArgument(want >= 0, "want should be x>=0");
            this.want = want;
            return this;
        }

        public Emot build() {
            return new Emot(article_Index, likes, warm, sad, mad, want);
        }
    }
}
