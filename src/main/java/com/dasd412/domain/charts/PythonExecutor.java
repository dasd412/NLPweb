package com.dasd412.domain.charts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PythonExecutor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String COMMAND = "py";
    private final String PATH = "C:\\Users\\dasd4\\Desktop\\python_exceute\\test.py";
    private final String ENCODE = "CP949";

    public List<String> executePython(String startDate, String endDate, String candidates,
        String source) throws Exception {
        logger.info("execute python file");

        List<String> resultList = new ArrayList<>();

        String[] cmdArray = {COMMAND, PATH, startDate, endDate, candidates, source};

        ProcessBuilder builder = new ProcessBuilder(cmdArray);
        Process process = builder.start();
        int exitVal = process.waitFor();  // 자식 프로세스가 종료될 때까지 기다림
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),
            ENCODE)); // 서브 프로세스가 출력하는 내용을 받기 위해
        String line;
        while ((line = br.readLine()) != null) {
            resultList.add(line);
        }

        return resultList;
    }

}
