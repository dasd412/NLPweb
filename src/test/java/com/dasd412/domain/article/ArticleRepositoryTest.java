package com.dasd412.domain.article;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;
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

//    @Autowired
//    ReplyRepository replyRepository;
//
//    @Autowired
//    EmotRepository emotRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    String id = "TEST";
    String title = "test01";
    String comp = "donga";
    String editor = "abc";
    String keyword = "moon";
    LocalDateTime time = LocalDateTime.of(2021, 10, 1, 0, 0, 0);

    String replyBody = "looooooooooooooooool";
    String replyKeyword = "mun";

    String emojiId = "asdasda";
    int likes = 5;
    int mad = 3;
    int sad = 4;
    int warm = 1;
    int want = 6;
    String emojiKeyWord = "moonmoon";

    @Transactional
    @Test
    public void save_article() {//아무 연관 관계 없이 저장 테스트.

        //given
        Article article = new Article.Builder()
            .article_Index(id)
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
        logger.info("article"+a);
        assertThat(a.getTitle()).isEqualTo(article.getTitle());
        assertThat(a.getComp()).isEqualTo(article.getComp());
        assertThat(a.getEditor()).isEqualTo(article.getEditor());
        assertThat(a.getDate()).isEqualTo(article.getDate());
    }

//    @Transactional
//    @Test
//    public void save_article_with_reply() {//기사에 답글 연관관계 추가해서 엔티티 저장 테스트.
//        //given
//        Article article = new Article.Builder()
//            .article_Index(id)
//            .title(title)
//            .comp(comp)
//            .editor(editor)
//            .keyWord(keyword)
//            .dateTime(time)
//            .build();
//
//        articleRepository.save(article);
//
//        Reply reply = new Reply.Builder()
//            .body(replyBody)
//            .keyWord(replyKeyword)
//            .dateTime(time)
//            .build();
//
//        reply.setArticle(article);
//        replyRepository.save(reply);
//
//        //when
//        Reply foundReply = replyRepository.findAll().get(0);
//
//        //then
//        logger.info("article" + article);
//        logger.info("reply" + reply + reply.getArticle().toString());
//
//        assertThat(foundReply.getBody()).isEqualTo(reply.getBody());
//        assertThat(foundReply.getKeyWord()).isEqualTo(reply.getKeyWord());
//        assertThat(foundReply.getDate()).isEqualTo(reply.getDate());
//
//        assertThat(foundReply.getArticle().getTitle()).isEqualTo(article.getTitle());
//        assertThat(foundReply.getArticle().getComp()).isEqualTo(article.getComp());
//        assertThat(foundReply.getArticle().getEditor()).isEqualTo(article.getEditor());
//        assertThat(foundReply.getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
//        assertThat(foundReply.getArticle().getDate()).isEqualTo(article.getDate());
//
//    }
//
//    @Transactional
//    @Test
//    public void save_article_with_replies() {//
//        //given
//        Article article = new Article.Builder()
//            .article_Index(id)
//            .title(title)
//            .comp(comp)
//            .editor(editor)
//            .keyWord(keyword)
//            .dateTime(time)
//            .build();
//
//        articleRepository.save(article);
//
//        IntStream.range(0, 10).forEach(i -> {
//            Reply reply = new Reply.Builder()
//                .body(replyBody + " : " + i)
//                .keyWord(replyKeyword + " : " + i)
//                .dateTime(time)
//                .build();
//
//            reply.setArticle(article);
//            replyRepository.save(reply);
//        });
//
//        //when
//        List<Reply> replyList = replyRepository.findAll();
//
//        //then
//        logger.info("article" + article);
//        logger.info("replyList" + replyList);
//
//        IntStream.range(0, 10).forEach(i -> {
//            assertThat(replyList.get(i).getArticle().getTitle()).isEqualTo(article.getTitle());
//            assertThat(replyList.get(i).getArticle().getComp()).isEqualTo(article.getComp());
//            assertThat(replyList.get(i).getArticle().getEditor()).isEqualTo(article.getEditor());
//            assertThat(replyList.get(i).getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
//            assertThat(replyList.get(i).getArticle().getDate()).isEqualTo(article.getDate());
//        });
//    }
//
//    @Transactional
//    @Test
//    public void save_article_with_emoji() {
//        //given
//        Article article = new Article.Builder()
//            .article_Index(id)
//            .title(title)
//            .comp(comp)
//            .editor(editor)
//            .keyWord(keyword)
//            .dateTime(time)
//            .build();
//
//        articleRepository.save(article);
//
//        Emot emot = new Emot.Builder()
//            .articleIndex(emojiId)
//            .likes(likes)
//            .sad(sad)
//            .mad(mad)
//            .warm(warm)
//            .want(want)
//            .keyWord(emojiKeyWord)
//            .build();
//
//        emot.setArticle(article);
//        emotRepository.save(emot);
//
//        //when
//        Emot foundEmot = emotRepository.findAll().get(0);
//
//        //then
//        logger.info("article" + article);
//        logger.info("emoji" + emot + emot.getArticle().toString());
//
//        assertThat(foundEmot.getArticle_Index()).isEqualTo(emot.getArticle_Index());
//        assertThat(foundEmot.getLikes()).isEqualTo(emot.getLikes());
//        assertThat(foundEmot.getSad()).isEqualTo(emot.getSad());
//        assertThat(foundEmot.getMad()).isEqualTo(emot.getMad());
//        assertThat(foundEmot.getWarm()).isEqualTo(emot.getWarm());
//        assertThat(foundEmot.getWant()).isEqualTo(emot.getWant());
//        assertThat(foundEmot.getKeyWord()).isEqualTo(emot.getKeyWord());
//
//        assertThat(foundEmot.getArticle().getTitle()).isEqualTo(article.getTitle());
//        assertThat(foundEmot.getArticle().getComp()).isEqualTo(article.getComp());
//        assertThat(foundEmot.getArticle().getEditor()).isEqualTo(article.getEditor());
//        assertThat(foundEmot.getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
//        assertThat(foundEmot.getArticle().getDate()).isEqualTo(article.getDate());
//
//
//    }
//
//    @Transactional
//    @Test
//    public void save_article_with_emojies() {
//        //given
//        Article article = new Article.Builder()
//            .article_Index(id)
//            .title(title)
//            .comp(comp)
//            .editor(editor)
//            .keyWord(keyword)
//            .dateTime(time)
//            .build();
//
//        articleRepository.save(article);
//
//        IntStream.range(0, 10).forEach(i -> {
//            Emot emot = new Emot.Builder()
//                .articleIndex(emojiId + ":" + i)
//                .likes(likes + i)
//                .sad(sad + i)
//                .mad(mad + i)
//                .warm(warm + i)
//                .want(want + i)
//                .keyWord(emojiKeyWord + "i")
//                .build();
//
//            emot.setArticle(article);
//            emotRepository.save(emot);
//        });
//
//        //when
//        List<Emot> emotList = emotRepository.findAll();
//
//        //then
//        logger.info("article" + article);
//        logger.info("emojiList" + emotList);
//
//        IntStream.range(0, 10).forEach(i -> {
//            assertThat(emotList.get(i).getArticle().getTitle()).isEqualTo(article.getTitle());
//            assertThat(emotList.get(i).getArticle().getComp()).isEqualTo(article.getComp());
//            assertThat(emotList.get(i).getArticle().getEditor()).isEqualTo(article.getEditor());
//            assertThat(emotList.get(i).getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
//            assertThat(emotList.get(i).getArticle().getDate()).isEqualTo(article.getDate());
//        });
//
//    }
//
//    @Transactional
//    @Test
//    public void save_article_with_replies_and_emojies() {
//        //given
//        Article article = new Article.Builder()
//            .article_Index(id)
//            .title(title)
//            .comp(comp)
//            .editor(editor)
//            .keyWord(keyword)
//            .dateTime(time)
//            .build();
//
//        articleRepository.save(article);
//
//        Reply reply = new Reply.Builder()
//            .body(replyBody)
//            .keyWord(replyKeyword)
//            .dateTime(time)
//            .build();
//
//        reply.setArticle(article);
//        replyRepository.save(reply);
//
//        Emot emot = new Emot.Builder()
//            .articleIndex(emojiId)
//            .likes(likes)
//            .sad(sad)
//            .mad(mad)
//            .warm(warm)
//            .want(want)
//            .keyWord(emojiKeyWord)
//            .build();
//
//        emot.setArticle(article);
//        emotRepository.save(emot);
//
//        //when
//        Reply foundReply = replyRepository.findAll().get(0);
//        Emot foundEmot = emotRepository.findAll().get(0);
//
//        //then
//        logger.info("article" + article);
//        logger.info("reply" + reply + reply.getArticle().toString());
//
//        assertThat(foundReply.getBody()).isEqualTo(reply.getBody());
//        assertThat(foundReply.getKeyWord()).isEqualTo(reply.getKeyWord());
//        assertThat(foundReply.getDate()).isEqualTo(reply.getDate());
//
//        assertThat(foundReply.getArticle().getTitle()).isEqualTo(article.getTitle());
//        assertThat(foundReply.getArticle().getComp()).isEqualTo(article.getComp());
//        assertThat(foundReply.getArticle().getEditor()).isEqualTo(article.getEditor());
//        assertThat(foundReply.getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
//        assertThat(foundReply.getArticle().getDate()).isEqualTo(article.getDate());
//
//        logger.info("emoji" + emot + emot.getArticle().toString());
//
//        assertThat(foundEmot.getArticle_Index()).isEqualTo(emot.getArticle_Index());
//        assertThat(foundEmot.getLikes()).isEqualTo(emot.getLikes());
//        assertThat(foundEmot.getSad()).isEqualTo(emot.getSad());
//        assertThat(foundEmot.getMad()).isEqualTo(emot.getMad());
//        assertThat(foundEmot.getWarm()).isEqualTo(emot.getWarm());
//        assertThat(foundEmot.getWant()).isEqualTo(emot.getWant());
//        assertThat(foundEmot.getKeyWord()).isEqualTo(emot.getKeyWord());
//
//        assertThat(foundEmot.getArticle().getTitle()).isEqualTo(article.getTitle());
//        assertThat(foundEmot.getArticle().getComp()).isEqualTo(article.getComp());
//        assertThat(foundEmot.getArticle().getEditor()).isEqualTo(article.getEditor());
//        assertThat(foundEmot.getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
//        assertThat(foundEmot.getArticle().getDate()).isEqualTo(article.getDate());
//
//
//    }

}