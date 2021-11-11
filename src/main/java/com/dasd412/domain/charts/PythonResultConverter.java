package com.dasd412.domain.charts;

import com.dasd412.controller.chart.LjmDTO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PythonResultConverter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LjmEntity convertLJM(List<String> result, int length) {
        logger.info("python result LJM convert" + result);

        List<Double> ratings = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ratings.add(Double.parseDouble(result.get(result.size() - 1 - i)));
        }

        logger.info("converted : " + ratings);
        return new LjmEntity(ratings);
    }
}
