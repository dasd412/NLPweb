package com.dasd412.controller.chart;

import com.dasd412.domain.charts.DummyData;
import com.dasd412.domain.charts.LjmEntity;
import com.dasd412.service.chart.PythonExecuteService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dasd412.controller.ApiResult;
import com.dasd412.service.chart.ChartService;

import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartRestController {

    private final ChartService chartService;
    private final PythonExecuteService pythonExecuteService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ChartRestController(ChartService chartService,
        PythonExecuteService pythonExecuteService) {
        this.chartService = chartService;
        this.pythonExecuteService = pythonExecuteService;
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

    @GetMapping("/api/nlp/charts/vs4/params")
    public void getDataOfVS4(@RequestParam Map<String, String> params) {
        logger.info("Get Mapped vs4 data" + params.toString());
        String startDate = params.get("startDate");
        String endDate = params.get("endDate");
        String source = params.get("source");

    }

    @GetMapping("/api/nlp/charts/LJM/params")
    public ApiResult<LjmDTO> getDataOfLJM(@RequestParam Map<String, String> params)
        throws Exception {
        logger.info("Get Mapped LJM data" + params.toString());
        String date = params.get("date");
        String candidate = params.get("candidate");
        String source = params.get("source");

        LjmDTO dto = new LjmDTO(
            pythonExecuteService.executeAndConvertPython(date, candidate, source)
                .orElseThrow(Exception::new));
        return ApiResult.OK(dto);
    }

    @GetMapping("/api/nlp/charts/MJI/params")
    public void getDataOfMJI(@RequestParam Map<String, String> params) {
        logger.info("Get Mapped MJI data" + params.toString());
        String source = params.get("source");

    }
}
