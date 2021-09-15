package com.dasd412.controller.chart;

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
}
