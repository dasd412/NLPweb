package com.dasd412.controller.chart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/api/nlp/charts")
    public String viewResolve(Model model) {
        return "/charts/charts";
    }
}
