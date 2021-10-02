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
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    //언론사
    private String comp;

    private String editor;

    private String keyWord;

    private LocalDateTime date;

    protected Article() {
    }

    public Article(String title, String comp, String editor, String keyWord, LocalDateTime date) {
        this.title = title;
        this.comp = comp;
        this.editor = editor;
        this.keyWord = keyWord;
        this.date = date;
    }

    public Long getId() {
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

        private Long id;
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

        public Builder id(long id) {
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
            return new Article(title, comp, editor, keyWord, date);
        }
    }
}
