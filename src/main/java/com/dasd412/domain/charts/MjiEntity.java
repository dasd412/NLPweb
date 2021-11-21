package com.dasd412.domain.charts;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class MjiEntity {
    private  List<Double> positiveRatings;
    private  List<Double> neutralRatings;
    private  List<Double> negativeRatings;

    public MjiEntity(List<Double> positiveRatings, List<Double> neutralRatings, List<Double> negativeRatings) {
        this.positiveRatings = positiveRatings;
        this.neutralRatings = neutralRatings;
        this.negativeRatings = negativeRatings;
    }

    public List<Double> getPositiveRatings() {
        return positiveRatings;
    }

    public List<Double> getNeutralRatings() {
        return neutralRatings;
    }

    public List<Double> getNegativeRatings() {
        return negativeRatings;
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
