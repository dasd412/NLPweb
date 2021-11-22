package com.dasd412.controller.chart;

import com.dasd412.domain.charts.LjmEntity;
import com.dasd412.domain.charts.MjiEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class MjiDTO {
    private  final double positiveRatings;
    private  final double neutralRatings;
    private  final double negativeRatings;

    public MjiDTO(double positiveRatings,  double negativeRatings, double neutralRatings) {
        this.positiveRatings = positiveRatings;
        this.neutralRatings = neutralRatings;
        this.negativeRatings = negativeRatings;
    }

    public double getPositiveRatings() {
        return positiveRatings;
    }

    public double getNeutralRatings() {
        return neutralRatings;
    }

    public double getNegativeRatings() {
        return negativeRatings;
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
                .append("negative",negativeRatings)
                .append("neutral",neutralRatings)
                .toString();
    }
}
