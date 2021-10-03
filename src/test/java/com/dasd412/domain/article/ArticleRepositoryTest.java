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

    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    EmojiRepository emojiRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    String id = "adasdd21331";
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
        logger.info("article"+a);
        assertThat(a.getTitle()).isEqualTo(article.getTitle());
        assertThat(a.getComp()).isEqualTo(article.getComp());
        assertThat(a.getEditor()).isEqualTo(article.getEditor());
        assertThat(a.getDate()).isEqualTo(article.getDate());
    }

    @Transactional
    @Test
    public void save_article_with_reply() {//기사에 답글 연관관계 추가해서 엔티티 저장 테스트.
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
        Reply foundReply = replyRepository.findAll().get(0);

        //then
        logger.info("article" + article);
        logger.info("reply" + reply + reply.getArticle().toString());

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
    public void save_article_with_replies() {//
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

        IntStream.range(0, 10).forEach(i -> {
            Reply reply = new Reply.Builder()
                .body(replyBody + " : " + i)
                .keyWord(replyKeyword + " : " + i)
                .dateTime(time)
                .build();

            reply.setArticle(article);
            replyRepository.save(reply);
        });

        //when
        List<Reply> replyList = replyRepository.findAll();

        //then
        logger.info("article" + article);
        logger.info("replyList" + replyList);

        IntStream.range(0, 10).forEach(i -> {
            assertThat(replyList.get(i).getArticle().getTitle()).isEqualTo(article.getTitle());
            assertThat(replyList.get(i).getArticle().getComp()).isEqualTo(article.getComp());
            assertThat(replyList.get(i).getArticle().getEditor()).isEqualTo(article.getEditor());
            assertThat(replyList.get(i).getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
            assertThat(replyList.get(i).getArticle().getDate()).isEqualTo(article.getDate());
        });
    }

    @Transactional
    @Test
    public void save_article_with_emoji() {
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

        Emoji emoji = new Emoji.Builder()
            .id(emojiId)
            .likes(likes)
            .sad(sad)
            .mad(mad)
            .warm(warm)
            .want(want)
            .keyWord(emojiKeyWord)
            .build();

        emoji.setArticle(article);
        emojiRepository.save(emoji);

        //when
        Emoji foundEmoji = emojiRepository.findAll().get(0);

        //then
        logger.info("article" + article);
        logger.info("emoji" + emoji + emoji.getArticle().toString());

        assertThat(foundEmoji.getId()).isEqualTo(emoji.getId());
        assertThat(foundEmoji.getLikes()).isEqualTo(emoji.getLikes());
        assertThat(foundEmoji.getSad()).isEqualTo(emoji.getSad());
        assertThat(foundEmoji.getMad()).isEqualTo(emoji.getMad());
        assertThat(foundEmoji.getWarm()).isEqualTo(emoji.getWarm());
        assertThat(foundEmoji.getWant()).isEqualTo(emoji.getWant());
        assertThat(foundEmoji.getKeyWord()).isEqualTo(emoji.getKeyWord());

        assertThat(foundEmoji.getArticle().getTitle()).isEqualTo(article.getTitle());
        assertThat(foundEmoji.getArticle().getComp()).isEqualTo(article.getComp());
        assertThat(foundEmoji.getArticle().getEditor()).isEqualTo(article.getEditor());
        assertThat(foundEmoji.getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
        assertThat(foundEmoji.getArticle().getDate()).isEqualTo(article.getDate());


    }

    @Transactional
    @Test
    public void save_article_with_emojies() {
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

        IntStream.range(0, 10).forEach(i -> {
            Emoji emoji = new Emoji.Builder()
                .id(emojiId + ":" + i)
                .likes(likes + i)
                .sad(sad + i)
                .mad(mad + i)
                .warm(warm + i)
                .want(want + i)
                .keyWord(emojiKeyWord + "i")
                .build();

            emoji.setArticle(article);
            emojiRepository.save(emoji);
        });

        //when
        List<Emoji> emojiList = emojiRepository.findAll();

        //then
        logger.info("article" + article);
        logger.info("emojiList" + emojiList);

        IntStream.range(0, 10).forEach(i -> {
            assertThat(emojiList.get(i).getArticle().getTitle()).isEqualTo(article.getTitle());
            assertThat(emojiList.get(i).getArticle().getComp()).isEqualTo(article.getComp());
            assertThat(emojiList.get(i).getArticle().getEditor()).isEqualTo(article.getEditor());
            assertThat(emojiList.get(i).getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
            assertThat(emojiList.get(i).getArticle().getDate()).isEqualTo(article.getDate());
        });

    }

    @Transactional
    @Test
    public void save_article_with_replies_and_emojies() {
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

        Emoji emoji = new Emoji.Builder()
            .id(emojiId)
            .likes(likes)
            .sad(sad)
            .mad(mad)
            .warm(warm)
            .want(want)
            .keyWord(emojiKeyWord)
            .build();

        emoji.setArticle(article);
        emojiRepository.save(emoji);

        //when
        Reply foundReply = replyRepository.findAll().get(0);
        Emoji foundEmoji = emojiRepository.findAll().get(0);

        //then
        logger.info("article" + article);
        logger.info("reply" + reply + reply.getArticle().toString());

        assertThat(foundReply.getBody()).isEqualTo(reply.getBody());
        assertThat(foundReply.getKeyWord()).isEqualTo(reply.getKeyWord());
        assertThat(foundReply.getDate()).isEqualTo(reply.getDate());

        assertThat(foundReply.getArticle().getTitle()).isEqualTo(article.getTitle());
        assertThat(foundReply.getArticle().getComp()).isEqualTo(article.getComp());
        assertThat(foundReply.getArticle().getEditor()).isEqualTo(article.getEditor());
        assertThat(foundReply.getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
        assertThat(foundReply.getArticle().getDate()).isEqualTo(article.getDate());

        logger.info("emoji" + emoji + emoji.getArticle().toString());

        assertThat(foundEmoji.getId()).isEqualTo(emoji.getId());
        assertThat(foundEmoji.getLikes()).isEqualTo(emoji.getLikes());
        assertThat(foundEmoji.getSad()).isEqualTo(emoji.getSad());
        assertThat(foundEmoji.getMad()).isEqualTo(emoji.getMad());
        assertThat(foundEmoji.getWarm()).isEqualTo(emoji.getWarm());
        assertThat(foundEmoji.getWant()).isEqualTo(emoji.getWant());
        assertThat(foundEmoji.getKeyWord()).isEqualTo(emoji.getKeyWord());

        assertThat(foundEmoji.getArticle().getTitle()).isEqualTo(article.getTitle());
        assertThat(foundEmoji.getArticle().getComp()).isEqualTo(article.getComp());
        assertThat(foundEmoji.getArticle().getEditor()).isEqualTo(article.getEditor());
        assertThat(foundEmoji.getArticle().getKeyWord()).isEqualTo(article.getKeyWord());
        assertThat(foundEmoji.getArticle().getDate()).isEqualTo(article.getDate());


    }

}