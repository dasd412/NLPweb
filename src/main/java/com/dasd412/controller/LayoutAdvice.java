package com.dasd412.controller;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.Compiler;
import com.samskivert.mustache.Template;
import com.samskivert.mustache.Template.Fragment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;


@ControllerAdvice
public class LayoutAdvice {//머스테시 레이아웃 자동화를 돕는 클래스

    private final Mustache.Compiler compiler;

    @Autowired
    public LayoutAdvice(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @ModelAttribute("layout")
    public Mustache.Lambda layout(Map<String, Object> model) {
        return new Layout(compiler);
    }

    @ModelAttribute("naverMining")
    public Mustache.Lambda naverMining(Map<String, Object> model) {
        return new NaverLayout(compiler);
    }

    static class Layout implements Mustache.Lambda {

        String content;

        private final Mustache.Compiler compiler;

        public Layout(Mustache.Compiler compiler) {
            this.compiler = compiler;
        }

        @Override
        public void execute(Template.Fragment fragment, Writer writer) {
            content = fragment.execute();
            compiler.compile("{{>layout/layout}}")
                .execute(fragment.context(), writer);//자동 레이아웃 인클루딩하도록 컴파일.
        }
    }


    static class NaverLayout implements Mustache.Lambda {

        String content;

        private final Mustache.Compiler compiler;

        public NaverLayout(Compiler compiler) {
            this.compiler = compiler;
        }


        @Override
        public void execute(Fragment fragment, Writer writer) throws IOException {
            content = fragment.execute();
            compiler.compile("{{>mining_naver/naverMining}}")
                .execute(fragment.context(), writer);
        }
    }
}
