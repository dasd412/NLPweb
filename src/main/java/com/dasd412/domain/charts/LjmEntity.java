package com.dasd412.domain.charts;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LjmEntity {
    private final List<String> someText;

    public LjmEntity(List<String> someText) {
        this.someText = someText;
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
