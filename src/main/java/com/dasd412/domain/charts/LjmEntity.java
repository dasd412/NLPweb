package com.dasd412.domain.charts;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LjmEntity {
    private final List<Double> ratings;

    public LjmEntity(List<Double> ratings) {
        this.ratings = ratings;
    }

    public List<Double> getRatings() {
        return ratings;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("ratings", ratings)
                .toString();
    }
}
