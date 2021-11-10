package com.dasd412.domain.charts;

import com.dasd412.controller.chart.LjmDTO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PythonResultConverter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LjmEntity convertLJM(List<String> result) {
        logger.info("python result LJM convert");
        return new LjmEntity(result);
    }
}
