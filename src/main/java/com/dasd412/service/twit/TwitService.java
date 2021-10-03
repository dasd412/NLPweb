package com.dasd412.service.twit;

import com.dasd412.domain.twit.ReTwit;
import com.dasd412.domain.twit.ReTwitRepository;
import com.dasd412.domain.twit.TwitRepository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TwitService {

    private final ReTwitRepository reTwitRepository;
    private final TwitRepository twitRepository;

    public TwitService(ReTwitRepository reTwitRepository,
        TwitRepository twitRepository) {
        this.reTwitRepository = reTwitRepository;
        this.twitRepository = twitRepository;
    }

    @Transactional(readOnly = true)
    public List<ReTwit> getRetwitList() {
        return reTwitRepository.findAll();
    }


}
