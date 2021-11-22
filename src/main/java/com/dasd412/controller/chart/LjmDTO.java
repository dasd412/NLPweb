package com.dasd412.controller.chart;

import com.dasd412.domain.charts.LjmEntity;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LjmDTO {

    private final List<Double> ratings;

    public LjmDTO(List<Double> ratings) {
        this.ratings = ratings;
    }

    public LjmDTO(LjmEntity entity) {
        this.ratings = entity.getRatings();
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
