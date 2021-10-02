package com.dasd412.domain.article;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
public class Emoji {//기사와 다대일 관계

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int likes;

    private int warm;

    private int sad;

    private int mad;

    private int want;

    private String keyWord;

    protected Emoji() {
    }

    public Emoji(int likes, int warm, int sad, int mad, int want, String keyWord) {
        this.likes = likes;
        this.warm = warm;
        this.sad = sad;
        this.mad = mad;
        this.want = want;
        this.keyWord = keyWord;
    }

    public Long getId() {
        return id;
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

    public String getKeyWord() {
        return keyWord;
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
        Emoji emoji = (Emoji) obj;
        return Objects.equals(this.id, emoji.id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", id)
            .append("likes", likes)
            .append("warm", warm)
            .append("sad", sad)
            .append("mad", mad)
            .append("want", want)
            .append("keyWord", keyWord)
            .toString();
    }

    static public class Builder {

        private Long id;
        private int likes;
        private int warm;
        private int sad;
        private int mad;
        private int want;
        private String keyWord;

        public Builder() {
        }

        public Builder(Emoji emoji) {
            this.id = emoji.id;
            this.likes = emoji.likes;
            this.warm = emoji.warm;
            this.sad = emoji.sad;
            this.mad = emoji.mad;
            this.want = emoji.want;
            this.keyWord = emoji.keyWord;
        }

        public Builder id(long id) {
            this.id = id;
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

        public Builder keyWord(String keyWord) {
            checkArgument(keyWord.length() > 0 && keyWord.length() <= 20,
                "keyWord length should be 20>=x>0 ");
            this.keyWord = keyWord;
            return this;
        }

        public Emoji build() {
            return new Emoji(likes, warm, sad, mad, want, keyWord);
        }
    }
}
