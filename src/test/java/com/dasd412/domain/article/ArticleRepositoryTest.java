package com.dasd412.domain.article;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ReplyRepository replyRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    String id = "adasdd21331";
    String title = "test01";
    String comp = "donga";
    String editor = "abc";
    String keyword = "moon";
    LocalDateTime time = LocalDateTime.of(2021, 10, 1, 0, 0, 0);

    String replyBody = "looooooooooooooooool";
    String replyKeyword = "mun";

    @Transactional
    @Test
    public void save_article() {//아무 연관 관계 없이 저장 테스트.

        //given
        Article article = new Article.Builder()
            .id(id)
            .title(title)
            .comp(comp)
            .editor(editor)
            .keyWord(keyword)
            .dateTime(time)
            .build();

        articleRepository.save(article);

        //when
        List<Article> articleList = articleRepository.findAll();

        //then
        Article a = articleList.get(0);
        logger.info(a.toString());
        assertThat(a.getTitle()).isEqualTo(article.getTitle());
        assertThat(a.getComp()).isEqualTo(article.getComp());
        assertThat(a.getEditor()).isEqualTo(article.getEditor());
        assertThat(a.getDate()).isEqualTo(article.getDate());
    }

    @Transactional
    @Test
    public void save_article_with_replies() {//기사에 답글 연관관계 추가해서 엔티티 저장 테스트.
        //given
        Article article = new Article.Builder()
            .id(id)
            .title(title)
            .comp(comp)
            .editor(editor)
            .keyWord(keyword)
            .dateTime(time)
            .build();

        articleRepository.save(article);

        Reply reply = new Reply.Builder()
            .body(replyBody)
            .keyWord(replyKeyword)
            .dateTime(time)
            .build();

        reply.setArticle(article);
        replyRepository.save(reply);

        //when
        Reply foundReply=replyRepository.findAll().get(0);

        //then
        logger.info("article"+article.toString());
        logger.info("reply"+reply.toString()+reply.getArticle().toString());

        assertThat(foundReply.getBody()).isEqualTo(reply.getBody());
        assertThat(foundReply.getKeyWord()).isEqualTo(reply.getKeyWord());
        assertThat(foundReply.getDate()).isEqualTo(reply.getDate());

        assertThat(foundReply.getArticle().getTitle()).isEqualTo(article.getTitle());
        assertThat(foundReply.getArticle().getComp()).isEqualTo(article.getComp());
        assertThat(foundReply.getArticle().getEditor()).isEqualTo(article.getEditor());
        assertThat(foundReply.getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
        assertThat(foundReply.getArticle().getDate()).isEqualTo(article.getDate());

    }

    @Transactional
    @Test
    public void save_article_with_emojies() {

    }

    @Transactional
    @Test
    public void save_article_with_replies_and_emojies() {

    }

}