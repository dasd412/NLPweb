package com.dasd412.controller.chart;

import com.dasd412.domain.charts.DummyData;
import com.dasd412.domain.twit.ReTwit;
import com.dasd412.domain.twit.Twit;
import com.dasd412.service.twit.TwitService;
import java.util.ArrayList;
import java.util.List;

import com.dasd412.controller.ApiResult;
import com.dasd412.service.chart.ChartService;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartRestController {

    private final ChartService chartService;
    private final TwitService twitService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ChartRestController(ChartService chartService,
        TwitService twitService) {
        this.chartService = chartService;
        this.twitService = twitService;
    }

    @GetMapping("/api/nlp/charts/random")
    public ApiResult<DummyDTO> getRandomData() {
        logger.info("chartRestController GET random dummy data");
        return ApiResult.OK(new DummyDTO(chartService.getRandomDummy()));
    }

    @GetMapping("/api/nlp/charts/randomset")
    public ApiResult<List<DummyDTO>> getRandomSet() {
        logger.info("chartRestController GET random dummies set");
        List<DummyData> dummyDataList = chartService.getRandomDummies();
        List<DummyDTO> dtoList = new ArrayList<>();
        for (DummyData dummy : dummyDataList) {
            dtoList.add(new DummyDTO(dummy));
        }
        return ApiResult.OK(dtoList);
    }

//    @GetMapping("/api/nlp/twit/list")
//    public ApiResult<List<TwitResponseDto>> getTwitList() {
//        logger.info("get twit limit some number");
//        List<Twit> twitList = twitService.readTwit();
//        logger.info("twitlist"+twitList);
//
//        List<TwitResponseDto> dtoList = twitList.stream()
//            .map(TwitResponseDto::new)
//            .collect(Collectors.toList());
//        logger.info("dtolist"+dtoList);
//        return ApiResult.OK(dtoList);
//    }

    @GetMapping("/api/nlp/twit/list/{id}")
    public ApiResult<List<TwitResponseDto>> getTwitListOfReTwit(@PathVariable String id) {
        logger.info("get twit list of retwit");
        List<Twit> twitList = twitService.readTwitByReTwitId(id);

        List<TwitResponseDto> dtoList = twitList.stream()
            .map(TwitResponseDto::new)
            .collect(Collectors.toList());

        return ApiResult.OK(dtoList);
    }

    @GetMapping("/api/nlp/reTwit/list")
    public ApiResult<List<ReTwitResponseDto>> getReTwitList() {
        logger.info("get reTwit limit some number");
        List<ReTwit> reTwitList = twitService.readReTwit();

        List<ReTwitResponseDto> dtoList = reTwitList.stream()
            .map(ReTwitResponseDto::new)
            .collect(Collectors.toList());

        return ApiResult.OK(dtoList);
    }
}
