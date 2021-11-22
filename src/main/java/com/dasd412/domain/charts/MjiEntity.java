package com.dasd412.domain.charts;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MjiEntity {
    private  final double positiveRatings;
    private  final double negativeRatings;
    private  final double neutralRatings;

    public MjiEntity(double positiveRatings, double negativeRatings,double neutralRatings) {
        this.positiveRatings = positiveRatings;
        this.negativeRatings = negativeRatings;
        this.neutralRatings = neutralRatings;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("positive",positiveRatings)
                .append("negative",negativeRatings)
                .append("neutral",neutralRatings)
                .toString();
    }
}
