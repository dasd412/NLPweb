package com.dasd412.controller.nlp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TwitterTextMiningController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/api/nlp/mine/twitter/")
    public String viewResolve(Model model) {

        return "/mining_twitter/twitter";
    }

    //문재인
    @GetMapping("/api/nlp/mine/twitter/MJI")
    public String viewResolveMJI(Model model) {
        logger.info("MJI view");
        return "/mining_twitter/twitterMJI";
    }

    //윤석열
    @GetMapping("/api/nlp/mine/twitter/YSY")
    public String viewResolveYSY(Model model) {
        logger.info("YSY view");
        return "/mining_twitter/twitterYSY";
    }

    //이낙연
    @GetMapping("/api/nlp/mine/twitter/LNY")
    public String viewResolveLNY(Model model) {
        logger.info("LNY view");
        return "/mining_twitter/twitterLNY";
    }

    //이재명
    @GetMapping("/api/nlp/mine/twitter/LJM")
    public String viewResolveLJM(Model model) {
        logger.info("LJM view");
        return "/mining_twitter/twitterLJM";
    }

    //홍준표
    @GetMapping("/api/nlp/mine/twitter/HJP")
    public String viewResolveHJP(Model model) {
        logger.info("HJP view");
        return "/mining_twitter/twitterHJP";
    }

    //황교안
    @GetMapping("/api/nlp/mine/twitter/HKA")
    public String viewResolveHKA(Model model) {
        logger.info("HKA view");
        return "/mining_twitter/twitterHKA";
    }

    //주차별 트위터 결과 뷰 반환
    @GetMapping("/api/nlp/week/twitter")
    public String viewResolveWeekTwitter(Model model) {
        logger.info("week twitter view");
        return "/week_twitter/twitter";
    }

}
