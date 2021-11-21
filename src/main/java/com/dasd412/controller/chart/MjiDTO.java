package com.dasd412.controller.chart;

import com.dasd412.domain.charts.LjmEntity;
import com.dasd412.domain.charts.MjiEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class MjiDTO {
    private  List<Double> positiveRatings;
    private  List<Double> neutralRatings;
    private  List<Double> negativeRatings;

    public MjiDTO(List<Double> positiveRatings, List<Double> neutralRatings, List<Double> negativeRatings) {
        this.positiveRatings = positiveRatings;
        this.neutralRatings = neutralRatings;
        this.negativeRatings = negativeRatings;
    }

    public MjiDTO(MjiEntity entity) {
        this.positiveRatings=entity.getPositiveRatings();
        this.neutralRatings=entity.getNeutralRatings();
        this.negativeRatings=entity.getNegativeRatings();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("positive",positiveRatings)
                .append("neutral",neutralRatings)
                .append("negative",negativeRatings)
                .toString();
    }
}
