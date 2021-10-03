package com.dasd412.service.article;

import com.dasd412.domain.article.Article;
import com.dasd412.domain.article.ArticleRepository;
import com.dasd412.domain.article.EmojiRepository;
import com.dasd412.domain.article.ReplyRepository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final EmojiRepository emojiRepository;
    private final ReplyRepository replyRepository;

    public ArticleService(ArticleRepository articleRepository,
        EmojiRepository emojiRepository, ReplyRepository replyRepository) {
        this.articleRepository = articleRepository;
        this.emojiRepository = emojiRepository;
        this.replyRepository = replyRepository;
    }

    @Transactional(readOnly = true)
    public List<Article>getArticleList(){
        return articleRepository.findAll();
    }

}
