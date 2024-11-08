package com.bhui.rocketmqdemo.service;

import com.bhui.rocketmqdemo.entity.Article;

public interface AtricleService {
    void publishArticle(Article article);
    void approveArticle(Long articleId);
}
