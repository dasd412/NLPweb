package com.dasd412.domain.charts;

import java.util.Random;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DummyData {//임시 모델 데이터

    //지지율
    private final double approvalRating;
    //댓글
    private final String comment;

    //임시로 랜덤 댓글 생성
    private static final String[]randomCommentList= {"Like","Angry","Disgusting","Interesting","Sad"};

    //생성자 내에서 임시 지지율과 댓글 랜덤 생성.
    public DummyData(){
        this.approvalRating=Math.random()*100.0;
        int randomIndex=new Random().nextInt(5);
        this.comment=randomCommentList[randomIndex];
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("지지율",approvalRating)
            .append("댓글",comment)
            .toString();
    }

    public double getApprovalRating() {
        return approvalRating;
    }

    public String getComment() {
        return comment;
    }
}
