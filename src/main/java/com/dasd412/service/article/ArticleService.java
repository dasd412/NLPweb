package com.dasd412.service.article;

import com.dasd412.domain.article.Article;
import com.dasd412.domain.article.ArticleRepository;
import com.dasd412.domain.article.EmotRepository;
import com.dasd412.domain.article.ReplyRepository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
//    private final EmotRepository emotRepository;
//    private final ReplyRepository replyRepository;
//
//    public ArticleService(ArticleRepository articleRepository,
//        EmotRepository emotRepository, ReplyRepository replyRepository) {
//        this.articleRepository = articleRepository;
//        this.emotRepository = emotRepository;
//        this.replyRepository = replyRepository;
//    }


    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional(readOnly = true)
    public List<Article>getArticleList(){
        return articleRepository.findAll();
    }

}
