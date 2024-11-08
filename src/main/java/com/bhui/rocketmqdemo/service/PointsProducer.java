package com.bhui.rocketmqdemo.service;

import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsProducer {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendPointsMessage(Long userId,int points){
        rocketMQTemplate.convertAndSend("PointsTopic_bhui:ArticleApproved_bhui",userId+":"+points);
    }
}
