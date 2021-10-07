package com.dasd412.service.twit;

import com.dasd412.domain.twit.ReTwit;
import com.dasd412.domain.twit.ReTwitRepository;
import com.dasd412.domain.twit.Twit;
import com.dasd412.domain.twit.TwitRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TwitService {

    private final ReTwitRepository reTwitRepository;
    private final TwitRepository twitRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TwitService(ReTwitRepository reTwitRepository,
        TwitRepository twitRepository) {
        this.reTwitRepository = reTwitRepository;
        this.twitRepository = twitRepository;
    }

    @Transactional(readOnly = true)
    public List<ReTwit> readReTwit(int start) {
        int end = start+5;
        Pageable limit = PageRequest.of(start, end);
        return reTwitRepository.findAllBy(limit);
    }

//    @Transactional(readOnly = true)
//    public List<Twit> readTwit() {
//        int start = 0;
//        int end = 10;
//        Pageable limit = PageRequest.of(start, end);
//        Page<Twit> twits = twitRepository.findAll(limit);
//        logger.info("found twits"+twits);
//        return twits.getContent();
//    }

    @Transactional(readOnly = true)
    public List<Twit> readTwitByReTwitId(String reTwitId) {
        logger.info("service : "+reTwitId);
        Optional<List<Twit>> found = twitRepository.findAllByReTwitId(reTwitId);
        return found.orElseThrow(NoSuchElementException::new);
    }

}
