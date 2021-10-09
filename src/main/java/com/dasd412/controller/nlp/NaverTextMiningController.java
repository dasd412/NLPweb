package com.dasd412.controller.nlp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverTextMiningController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/api/nlp/mine/naver/")
    public String viewResolve(Model model) {
        logger.info("MJI view");
        return "/mining_naver/naver";
    }

    //문재인
    @GetMapping("/api/nlp/mine/naver/MJI")
    public String viewResolveMJI(Model model) {
        logger.info("MJI view");
        return "/mining_naver/naverMJI";
    }

    //윤석열
    @GetMapping("/api/nlp/mine/naver/YSY")
    public String viewResolveYSY(Model model) {
        logger.info("YSY view");
        return "/mining_naver/naverYSY";
    }

    //이낙연
    @GetMapping("/api/nlp/mine/naver/LNY")
    public String viewResolveLNY(Model model) {
        logger.info("LNY view");
        return "/mining_naver/naverLNY";
    }

    //이재명
    @GetMapping("/api/nlp/mine/naver/LJM")
    public String viewResolveLJM(Model model) {
        logger.info("LJM view");
        return "/mining_naver/naverLJM";
    }

    //홍준표
    @GetMapping("/api/nlp/mine/naver/HJP")
    public String viewResolveHJP(Model model) {
        logger.info("HJP view");
        return "/mining_naver/naverHJP";
    }

    //황교안
    @GetMapping("/api/nlp/mine/naver/HKA")
    public String viewResolveHKA(Model model) {
        logger.info("HKA view");
        return "/mining_naver/naverHKA";
    }
}
