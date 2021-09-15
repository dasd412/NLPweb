package com.dasd412.controller.chart;

import com.dasd412.domain.charts.DummyData;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DummyDTO {

    //지지율
    private final double approvalRating;
    //댓글
    private final String comment;

    public DummyDTO(DummyData dummyData) {
        this.approvalRating = dummyData.getApprovalRating();
        this.comment = dummyData.getComment();
    }

    public double getApprovalRating() {
        return approvalRating;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("지지율",approvalRating)
            .append("댓글",comment)
            .toString();
    }
}
