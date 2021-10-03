package com.dasd412.domain.twit;

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
public class ReTwitRepositoryTest {

    @Autowired
    ReTwitRepository reTwitRepository;

    @Autowired
    TwitRepository twitRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    String reTwitId = "adsaddga";
    String reTwitBody = "asfsdgsdad";
    String reTwitWorked = "asdafgafs";
    String reTwitDeleted = "asdhjtrd";
    String reTwitKeyWord = "wdafgwad";

    String twitBody = "ghkgkgh";
    String hashtag = "htkgrtky";
    String twitWorked = "dsghj";
    String twitDeleted = "asfshg";
    String originId = reTwitId;
    String twitKeyWord = "asdasd13123";
    LocalDateTime date = LocalDateTime.of(2021, 10, 3, 0, 0, 0);

    @Transactional
    @Test
    public void save_reTwit() {
        //given
        ReTwit reTwit = new ReTwit.Builder()
            .id(reTwitId)
            .body(reTwitBody)
            .worked(reTwitWorked)
            .deleted(reTwitDeleted)
            .keyWord(reTwitKeyWord)
            .build();

        reTwitRepository.save(reTwit);

        //when
        ReTwit found = reTwitRepository.findAll().get(0);

        //then
        logger.info("retwit" + found.toString());
        assertThat(found.getId()).isEqualTo(reTwit.getId());
        assertThat(found.getBody()).isEqualTo(reTwit.getBody());
        assertThat(found.getWorked()).isEqualTo(reTwit.getWorked());
        assertThat(found.getDeleted()).isEqualTo(reTwit.getDeleted());
        assertThat(found.getKeyWord()).isEqualTo(reTwit.getKeyWord());

    }

    @Transactional
    @Test
    public void save_reTwit_with_Twit() {
        //given
        ReTwit reTwit = new ReTwit.Builder()
            .id(reTwitId)
            .body(reTwitBody)
            .worked(reTwitWorked)
            .deleted(reTwitDeleted)
            .keyWord(reTwitKeyWord)
            .build();

        reTwitRepository.save(reTwit);

        Twit twit = new Twit.Builder()
            .body(twitBody)
            .hashtag(hashtag)
            .worked(twitWorked)
            .deleted(twitDeleted)
            .originId(originId)
            .isRe_twitted(true)
            .keyWord(twitKeyWord)
            .date(date)
            .build();

        twit.setReTwit(reTwit);
        twitRepository.save(twit);

        //when
        Twit foundTwit = twitRepository.findAll().get(0);

        //then
        logger.info("reTwit" + reTwit);
        logger.info("twit" + foundTwit + " " + foundTwit.getReTwit().toString());

        assertThat(foundTwit.getBody()).isEqualTo(twit.getBody());
        assertThat(foundTwit.getHashtag()).isEqualTo(twit.getHashtag());
        assertThat(foundTwit.getWorked()).isEqualTo(twit.getWorked());
        assertThat(foundTwit.getDeleted()).isEqualTo(twit.getDeleted());
        assertThat(foundTwit.getOriginId()).isEqualTo(twit.getOriginId());
        assertThat(foundTwit.getKeyWord()).isEqualTo(twit.getKeyWord());
        assertThat(foundTwit.getDate()).isEqualTo(twit.getDate());
        assertThat(foundTwit.isRetwitted()).isEqualTo(true);
        assertThat(foundTwit.getReTwit()).isEqualTo(reTwit);


    }

    @Transactional
    @Test
    public void save_reTwit_with_Twits() {
        //given
        ReTwit reTwit = new ReTwit.Builder()
            .id(reTwitId)
            .body(reTwitBody)
            .worked(reTwitWorked)
            .deleted(reTwitDeleted)
            .keyWord(reTwitKeyWord)
            .build();

        reTwitRepository.save(reTwit);

        IntStream.range(0, 10).forEach(i -> {
            Twit twit = new Twit.Builder()
                .body(twitBody + i)
                .hashtag(hashtag + i)
                .worked(twitWorked + i)
                .deleted(twitDeleted + i)
                .originId(originId)
                .keyWord(twitKeyWord + i)
                .date(date)
                .isRe_twitted(true)
                .build();

            twit.setReTwit(reTwit);
            twitRepository.save(twit);
        });

        //when
        List<Twit> twitList = twitRepository.findAll();

        //then
        logger.info("reTwit" + reTwit);
        logger.info("twitList" + twitList);

        IntStream.range(0, 10).forEach(i -> {
            assertThat(twitList.get(i).getReTwit().getId()).isEqualTo(reTwit.getId());
            assertThat(twitList.get(i).getReTwit().getBody()).isEqualTo(reTwit.getBody());
            assertThat(twitList.get(i).getReTwit().getWorked()).isEqualTo(reTwit.getWorked());
            assertThat(twitList.get(i).getReTwit().getDeleted()).isEqualTo(reTwit.getDeleted());
            assertThat(twitList.get(i).getReTwit().getKeyWord()).isEqualTo(reTwit.getKeyWord());
        });
    }
}