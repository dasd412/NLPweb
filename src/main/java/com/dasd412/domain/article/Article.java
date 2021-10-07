package com.dasd412.domain.article;


import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
public class Article {//Emoji, reply와 1대 다 관계임

    @Id
    @Column(length = 768)
    private String article_Index;

    @Column(length = 100)
    private String title;

    //언론사
    @Column(length = 20)
    private String comp;

    @Column(length = 20)
    private String editor;

    private LocalDateTime date;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TEXT")
    private String special_deleted;

    @Column(columnDefinition = "TEXT")
    private String Okt_pos;

    @Column(columnDefinition = "TEXT")
    private String stopwords_deleted;

    @Column(columnDefinition = "TEXT")
    private String noun;

    @Column(columnDefinition = "TEXT")
    private String n_v_adj_ad;

    protected Article() {
    }

    public Article(String article_Index, String title, String comp, String editor,
        LocalDateTime date, String body,
        String special_deleted, String okt_pos, String stopwords_deleted, String noun,
        String n_v_adj_ad) {
        this.article_Index = article_Index;
        this.title = title;
        this.comp = comp;
        this.editor = editor;
        this.date = date;
        this.body = body;
        this.special_deleted = special_deleted;
        Okt_pos = okt_pos;
        this.stopwords_deleted = stopwords_deleted;
        this.noun = noun;
        this.n_v_adj_ad = n_v_adj_ad;
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

    public LocalDateTime getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }

    public String getSpecial_deleted() {
        return special_deleted;
    }

    public String getOkt_pos() {
        return Okt_pos;
    }

    public String getStopwords_deleted() {
        return stopwords_deleted;
    }

    public String getNoun() {
        return noun;
    }

    public String getN_v_adj_ad() {
        return n_v_adj_ad;
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
            .append("date", date)
            .append("body", body)
            .append("special_deleted", special_deleted)
            .append("okt_pos", Okt_pos)
            .append("stopwords_deleted", stopwords_deleted)
            .append("noun", noun)
            .append("n_v_adj_ad", n_v_adj_ad)
            .toString();
    }

    static public class Builder {

        private String article_Index;
        private String title;
        private String comp;
        private String editor;
        private LocalDateTime date;
        private String body;
        private String special_deleted;
        private String okt_pos;
        private String stopwords_deleted;
        private String noun;
        private String n_v_adj_ad;

        public Builder() {
        }

        public Builder(Article article) {
            this.article_Index = article.article_Index;
            this.title = article.title;
            this.comp = article.comp;
            this.editor = article.editor;
            this.date = article.date;
            this.body = article.body;
            this.special_deleted = article.special_deleted;
            this.okt_pos = article.Okt_pos;
            this.stopwords_deleted = article.stopwords_deleted;
            this.noun = article.noun;
            this.n_v_adj_ad = article.n_v_adj_ad;
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

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder special_deleted(String special_deleted) {
            this.special_deleted = special_deleted;
            return this;
        }

        public Builder okt_pos(String okt_pos) {
            this.okt_pos = okt_pos;
            return this;
        }

        public Builder stopwords_deleted(String stopwords_deleted) {
            this.stopwords_deleted = stopwords_deleted;
            return this;
        }

        public Builder noun(String noun) {
            this.noun = noun;
            return this;
        }

        public Builder n_v_adj_ad(String n_v_adj_ad) {
            this.n_v_adj_ad = n_v_adj_ad;
            return this;
        }

        public Article build() {
            return new Article(article_Index, title, comp, editor, date, body,
                special_deleted, okt_pos, stopwords_deleted, noun,
                n_v_adj_ad);
        }
    }
}
