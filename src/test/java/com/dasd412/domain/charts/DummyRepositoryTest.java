package com.dasd412.domain.charts;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DummyRepositoryTest {

    private final DummyRepository repository=new DummyRepository();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void TestMakeDummyData(){

        List<DummyData>dummyList=new ArrayList<>();
        for(int i=0;i<20;i++){
            dummyList.add(repository.makeDummyData());
        }

        logger.info("dummy list:"+dummyList);

    }
}