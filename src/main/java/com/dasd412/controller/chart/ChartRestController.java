package com.dasd412.controller.chart;

import com.dasd412.domain.charts.DummyData;
import com.dasd412.domain.twit.ReTwit;
import com.dasd412.domain.twit.Twit;
import com.dasd412.service.twit.TwitService;
import java.util.ArrayList;
import java.util.List;

import com.dasd412.controller.ApiResult;
import com.dasd412.service.chart.ChartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartRestController {

    private final ChartService chartService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ChartRestController(ChartService chartService) {
        this.chartService = chartService;
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
}
