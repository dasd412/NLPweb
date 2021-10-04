package com.dasd412.domain.article;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
public class Article {//Emoji, reply와 1대 다 관계임

    @Id
    @Column(length = 768)
    private String article_Index;

    @Column(length=100)
    private String title;

    //언론사
    @Column(length=20)
    private String comp;

    @Column(length=20)
    private String editor;

    @Column(name="keyword",length=20)
    private String keyWord;

    private LocalDateTime date;

//    @JsonIgnore
//    @OneToMany(mappedBy = "article")
//    List<Reply> replies = new ArrayList<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "article")
//    List<Emot> emotList = new ArrayList<>();

    protected Article() {
    }

    public Article(String article_Index, String title, String comp, String editor, String keyWord,
        LocalDateTime date) {
        this.article_Index = article_Index;
        this.title = title;
        this.comp = comp;
        this.editor = editor;
        this.keyWord = keyWord;
        this.date = date;
    }

    public String getArticle_Index() {
        return article_Index;
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

//    public List<Reply> getReplies() {
//        return replies;
//    }
//
//    public List<Emot> getEmojiList() {
//        return emotList;
//    }
//
//    public void addReply(Reply reply) {
//        this.replies.add(reply);
//
//        //무한 루프 방지용
//        if (reply.getArticle() != this) {
//            reply.setArticle(this);
//        }
//    }
//
//    public void addEmoji(Emot emot) {
//        this.emotList.add(emot);
//
//        //무한 루프 방지용
//        if (emot.getArticle() != this) {
//            emot.setArticle(this);
//        }
//    }

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
        Article article = (Article) obj;
        return Objects.equals(this.article_Index, article.article_Index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("article_Index", article_Index)
            .append("title", title)
            .append("comp", comp)
            .append("editor", editor)
            .append("keyword", keyWord)
            .append("date", date)
            .toString();
    }

    static public class Builder {

        private String article_Index;
        private String title;
        private String comp;
        private String editor;
        private String keyWord;
        private LocalDateTime date;

        public Builder() {
        }

        public Builder(Article article) {
            this.article_Index = article.article_Index;
            this.title = article.title;
            this.comp = article.comp;
            this.keyWord = article.keyWord;
            this.editor = article.editor;
            this.date = article.date;
        }

        public Builder article_Index(String article_Index) {
            checkArgument(article_Index.length() > 0 && article_Index.length() <= 768,
                "id length should be 0<x<=768");
            this.article_Index = article_Index;
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
            return new Article(article_Index, title, comp, editor, keyWord, date);
        }
    }
}
