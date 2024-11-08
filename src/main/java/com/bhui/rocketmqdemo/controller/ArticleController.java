package com.bhui.rocketmqdemo.controller;

import com.bhui.rocketmqdemo.entity.Article;
import com.bhui.rocketmqdemo.mapper.AtricleMapper;
import com.bhui.rocketmqdemo.service.AtricleService;
import com.bhui.rocketmqdemo.service.PointsProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author JXS
 */
@RestController
@AllArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final AtricleService atricleService;
    private final AtricleMapper atricleMapper;

    private final PointsProducer producer;

    @PostMapping("/publish")
    public String  publishArticle(@RequestBody Article article){
        atricleService.publishArticle(article);
        return "发布成功";
    }

    @PostMapping("/approve/{id}")
    public String  approveArticle(@PathVariable Long id){
        atricleService.approveArticle(id);
        //增加积分
        Article article = atricleMapper.selectById(id);
        producer.sendPointsMessage(article.getUserId(),50);
        return "文章通过,积分奖励发放";
    }

}
