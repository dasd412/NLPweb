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
    public void executePython()throws Exception {

        final String command="py";
        final String path="C:\\Users\\dasd4\\Desktop\\python_exceute\\test.py";
        String startDate="20211009";
        String endDate="20211020";
        String candidates="이재명,윤석열";
        String source="NAVER";

        List<String>lineBucket=new ArrayList<>();

        String[]cmdArray={command,path,startDate,endDate,candidates,source};

        ProcessBuilder builder = new ProcessBuilder(cmdArray);
        Process process = builder.start();
        int exitVal = process.waitFor();  // 자식 프로세스가 종료될 때까지 기다림
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),
            "CP949")); // 서브 프로세스가 출력하는 내용을 받기 위해
        String line;
        while ((line = br.readLine()) != null) {
            lineBucket.add(line);
        }
        if(exitVal != 0) {
            // 비정상 종료
            System.out.println("서브 프로세스가 비정상 종료되었다.");
        }

        for(String s:lineBucket){
            System.out.println(s);
        }

    }
}
