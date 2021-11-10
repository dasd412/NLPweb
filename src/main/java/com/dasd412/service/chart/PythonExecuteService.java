package com.dasd412.service.chart;

import com.dasd412.domain.charts.LjmEntity;
import com.dasd412.domain.charts.PythonExecutor;
import com.dasd412.domain.charts.PythonResultConverter;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PythonExecuteService {

    private final PythonExecutor executor;
    private final PythonResultConverter converter;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PythonExecuteService(PythonExecutor executor,
        PythonResultConverter converter) {
        this.executor = executor;
        this.converter = converter;
    }

    public Optional<LjmEntity> executeAndConvertPython(String startDate, String endDate,
        String candidate, String source) {
        try {
            List<String> result = executor.executePython(startDate, endDate, candidate, source);
            return Optional.of(converter.convertLJM(result));
        } catch (Exception e) {
            logger.error("failed reading python!!");
        }
        return Optional.empty();
    }


}
