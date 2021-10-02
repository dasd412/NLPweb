package com.dasd412.domain.article;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;

import org.junit.After;
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
    ArticleRepository repository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @After
    public void cleanUp() {
        repository.deleteAll();
    }

    @Transactional
    @Test
    public void save_article(){
        String id="adasdd21331";
        String title="test01";
        String comp="donga";
        String editor="abc";
        String keyword="moon";
        LocalDateTime time=LocalDateTime.of(2021,10,1,0,0,0);

        //given
        Article article=new Article.Builder()
            .id(id)
            .title(title)
            .comp(comp)
            .editor(editor)
            .keyWord(keyword)
            .dateTime(time)
            .build();

        repository.save(article);
        //when
        List<Article>articleList=repository.findAll();

        //then
        Article a=articleList.get(0);
        logger.info(a.toString());
        assertThat(a.getTitle()).isEqualTo(article.getTitle());
        assertThat(a.getComp()).isEqualTo(article.getComp());
        assertThat(a.getEditor()).isEqualTo(article.getEditor());
        assertThat(a.getDate()).isEqualTo(article.getDate());
    }

    @Transactional
    @Test
    public void save_article_with_replies(){

    }

    @Transactional
    @Test
    public void save_article_with_emojies(){

    }

    @Transactional
    @Test
    public void save_article_with_replies_and_emojies(){

    }

}