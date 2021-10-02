package com.dasd412.domain.article;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
public class Emoji {//기사와 다대일 관계

    @Id
    private String id;

    private int likes;

    private int warm;

    private int sad;

    private int mad;

    private int want;

    private String keyWord;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    protected Emoji() {
    }

    public Emoji(String id,int likes, int warm, int sad, int mad, int want, String keyWord) {
        this.id=id;
        this.likes = likes;
        this.warm = warm;
        this.sad = sad;
        this.mad = mad;
        this.want = want;
        this.keyWord = keyWord;
    }

    public String getId() {
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

    public Article getArticle() {
        return article;
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

    public void setArticle(Article article) {
        this.article = article;
        //무한 루프 방지
        if (!article.getEmojiList().contains(this)) {
            article.getEmojiList().add(this);
        }
    }


    static public class Builder {

        private String id;
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

        public Builder id(String id) {
            checkArgument(id.length() > 0 && id.length() <= 768, "id length should be 768>=x>0");
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
            return new Emoji(id,likes, warm, sad, mad, want, keyWord);
        }
    }
}
