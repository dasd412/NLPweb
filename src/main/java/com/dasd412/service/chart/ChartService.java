package com.dasd412.service.chart;

import java.util.ArrayList;
import java.util.List;

import com.dasd412.domain.charts.DummyData;
import com.dasd412.domain.charts.DummyRepository;
import org.springframework.stereotype.Service;

@Service
public class ChartService {

    private final DummyRepository dummyRepository;

    public ChartService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public DummyData getRandomDummy() {
        return dummyRepository.makeDummyData();
    }

    public List<DummyData> getRandomDummies() {
        List<DummyData> dummyDataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dummyDataList.add(dummyRepository.makeDummyData());
        }
        return dummyDataList;
    }
}
