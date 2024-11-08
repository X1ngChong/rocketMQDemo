package com.bhui.rocketmqdemo.service.impl;

import com.bhui.rocketmqdemo.entity.Article;
import com.bhui.rocketmqdemo.mapper.AtricleMapper;
import com.bhui.rocketmqdemo.service.AtricleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtricleServiceImpl implements AtricleService {
    private final AtricleMapper atricleMapper;
    @Override
    public void publishArticle(Article article) {
        article.setStatus("PENDING");
        atricleMapper.insert(article);
    }

    @Override
    public void approveArticle(Long articleId) {
        Article article = atricleMapper.selectById(articleId);
        if(article !=null){
            article.setStatus("APPROVED");
            atricleMapper.updateById(article);
        }
    }
}
