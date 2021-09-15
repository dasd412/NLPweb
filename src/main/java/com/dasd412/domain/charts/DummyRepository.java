package com.dasd412.domain.charts;

import org.springframework.stereotype.Component;

@Component
public class DummyRepository {

    public DummyData makeDummyData() {
        return new DummyData();
    }

}
