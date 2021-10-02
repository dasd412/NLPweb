package com.dasd412.domain.article;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
public class Article {//Emoji, reply와 1대 다 관계임

    @Id
    private String id;

    private String title;

    //언론사
    private String comp;

    private String editor;

    private String keyWord;

    private LocalDateTime date;

    @JsonIgnore
    @OneToMany(mappedBy = "article")
    List<Reply> replies = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "article")
    List<Emoji> emojiList = new ArrayList<>();

    protected Article() {
    }

    public Article(String id, String title, String comp, String editor, String keyWord,
        LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.comp = comp;
        this.editor = editor;
        this.keyWord = keyWord;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getComp() {
        return comp;
    }

    public String getEditor() {
        return editor;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public List<Emoji> getEmojiList() {
        return emojiList;
    }

    public void addReply(Reply reply) {
        this.replies.add(reply);

        //무한 루프 방지용
        if (reply.getArticle() != this) {
            reply.setArticle(this);
        }
    }

    public void addEmoji(Emoji emoji) {
        this.emojiList.add(emoji);

        //무한 루프 방지용
        if (emoji.getArticle() != this) {
            emoji.setArticle(this);
        }
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
        Article article = (Article) obj;
        return Objects.equals(this.id, article.id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", id)
            .append("title", title)
            .append("comp", comp)
            .append("editor", editor)
            .append("keyword", keyWord)
            .append("date", date)
            .toString();
    }

    static public class Builder {

        private String id;
        private String title;
        private String comp;
        private String editor;
        private String keyWord;
        private LocalDateTime date;

        public Builder() {
        }

        public Builder(Article article) {
            this.id = article.id;
            this.title = article.title;
            this.comp = article.comp;
            this.keyWord = article.keyWord;
            this.editor = article.editor;
            this.date = article.date;
        }

        public Builder id(String id) {
            checkArgument(id.length() > 0 && id.length() <= 768,
                "id length should be 0<x<=768");
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            checkArgument(title.length() > 0 && title.length() <= 100,
                "title length should be 0<x<=100");
            this.title = title;
            return this;
        }

        public Builder comp(String comp) {
            checkArgument(comp.length() > 0 && comp.length() <= 20,
                "comp length should be 0<x<=20");
            this.comp = comp;
            return this;
        }

        public Builder keyWord(String keyWord) {
            checkArgument(keyWord.length() > 0 && keyWord.length() <= 20,
                "keyWord length should be 0<x<=20");
            this.keyWord = keyWord;
            return this;
        }

        public Builder editor(String editor) {
            checkArgument(editor.length() > 0 && editor.length() <= 20,
                "editor length should be 0<x<=20");
            this.editor = editor;
            return this;
        }

        public Builder dateTime(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Article build() {
            return new Article(id, title, comp, editor, keyWord, date);
        }
    }
}
