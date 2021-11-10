package com.dasd412.controller.chart;

import com.dasd412.domain.charts.LjmEntity;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LjmDTO {

    private final List<String> someText;

    public LjmDTO(List<String> someText) {
        this.someText = someText;
    }

    public LjmDTO(LjmEntity entity) {
        this.someText = entity.getSomeText();
    }

    public List<String> getSomeText() {
        return someText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("test", someText)
            .toString();
    }
}
