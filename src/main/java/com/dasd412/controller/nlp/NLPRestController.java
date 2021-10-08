package com.dasd412.controller.nlp;

import com.dasd412.controller.ApiResult;
import com.dasd412.domain.twit.ReTwit;
import com.dasd412.domain.twit.Twit;
import com.dasd412.service.twit.TwitService;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NLPRestController {

    private final TwitService twitService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public NLPRestController(TwitService twitService) {
        this.twitService = twitService;
    }

    @GetMapping("/api/nlp/twit/list/{id}")
    public ApiResult<List<TwitResponseDto>> getTwitListOfReTwit(@PathVariable String id) {
        logger.info("get twit list of retwit : " + id);
        List<Twit> twitList = twitService.readTwitByReTwitId(id);

        List<TwitResponseDto> dtoList = twitList.stream()
            .map(TwitResponseDto::new)
            .collect(Collectors.toList());

        return ApiResult.OK(dtoList);
    }

    @GetMapping("/api/nlp/reTwit/list/{start}")
    public ApiResult<List<ReTwitResponseDto>> getReTwitList(@PathVariable int start) {
        logger.info("get reTwit limit some number");
        List<ReTwit> reTwitList = twitService.readReTwit(start);

        List<ReTwitResponseDto> dtoList = reTwitList.stream()
            .map(ReTwitResponseDto::new)
            .collect(Collectors.toList());

        return ApiResult.OK(dtoList);
    }
}
