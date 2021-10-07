package com.dasd412.domain.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keyword_naver")
public class KewordNaver {

    @Id
    @Column(name = "article_Index")
    private String id;

    private boolean MJI;

    private boolean YSY;

    private boolean LNY;

    private boolean LJM;

    private boolean HJP;

    private boolean HKA;

    protected KewordNaver() {
    }

    public KewordNaver(String id, boolean MJI, boolean YSY, boolean LNY, boolean LJM, boolean HJP,
        boolean HKA) {
        this.id = id;
        this.MJI = MJI;
        this.YSY = YSY;
        this.LNY = LNY;
        this.LJM = LJM;
        this.HJP = HJP;
        this.HKA = HKA;
    }

    public String getId() {
        return id;
    }

    public boolean isMJI() {
        return MJI;
    }

    public boolean isYSY() {
        return YSY;
    }

    public boolean isLNY() {
        return LNY;
    }

    public boolean isLJM() {
        return LJM;
    }

    public boolean isHJP() {
        return HJP;
    }

    public boolean isHKA() {
        return HKA;
    }
}
