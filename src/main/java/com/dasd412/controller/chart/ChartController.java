package com.dasd412.controller.chart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/api/nlp/chart/vs")
    public String viewResolveVS(Model model) {
        return "/charts/vs";
    }

    @GetMapping("/api/nlp/chart/transitionMJI")
    public String viewResolveTransitionMJI(Model model) {
        return "/charts/transitionMJI";
    }
}
