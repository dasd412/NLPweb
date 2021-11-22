package com.dasd412.pythonExec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PythonExecuteTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void executePython() throws Exception {

        final String command = "py";
        final String path = "D:\\트위터크롤링\\graduationProj\\main.py";
        String startDate = "10-25";
        String endDate = "10-25";
        String candidates = "이재명 윤석열";
        String source = "NAVER";

        List<String> lineBucket = new ArrayList<>();

        String[] cmdArray = {command, path, candidates, startDate, endDate};

        ProcessBuilder builder = new ProcessBuilder(cmdArray);
        Process process = builder.start();
        int exitVal = process.waitFor();  // 자식 프로세스가 종료될 때까지 기다림
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),
            "CP949")); // 서브 프로세스가 출력하는 내용을 받기 위해
        String line;
        while ((line = br.readLine()) != null) {
            lineBucket.add(line);
        }
        if (exitVal != 0) {
            // 비정상 종료
            System.out.println("서브 프로세스가 비정상 종료되었다.");
        }

        for(int i=0;i<2;i++){
            System.out.println(lineBucket.get(lineBucket.size()-1-i));
        }

    }
}
