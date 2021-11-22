package com.dasd412.service.chart;

import com.dasd412.domain.charts.LjmEntity;
import com.dasd412.domain.charts.MjiEntity;
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
            String[] split = candidate.split(" ");
            logger.info("candidate : "+candidate);
            List<String> result = executor.executePython(startDate, endDate, candidate, source);
            logger.info("result vs : "+result);
            //return Optional.of(converter.convertLJM(result, split.length));

        } catch (Exception e) {
            logger.error("failed reading python!!");
        }
        return Optional.empty();
    }

    public Optional<MjiEntity>executeMjiPython(String startDate, String endDate,String source){

        try{
            List<String>result= executor.executeMjiPython(startDate, endDate, source);
            logger.info("result mji : "+result);
            return Optional.of(converter.convertMJI(result));
        } catch (Exception e) {
            logger.info("failed mji python");
        }
        return Optional.empty();
    }


}
