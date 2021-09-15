package com.dasd412.service.chart;

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
}
