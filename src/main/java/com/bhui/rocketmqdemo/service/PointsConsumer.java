package com.bhui.rocketmqdemo.service;

import com.bhui.rocketmqdemo.entity.PointsLog;
import com.bhui.rocketmqdemo.mapper.PointsLogMapper;
import lombok.AllArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author JXS
 */
@Service
@RocketMQMessageListener(topic = "PointsTopic_bhui",selectorExpression = "ArticleApproved_bhui",consumerGroup = "point_group_bhui")
@AllArgsConstructor
public class PointsConsumer implements RocketMQListener<String> {
        private final UserService userService;
        private final PointsLogMapper pointsLogMapper;

    @Override
    public void onMessage(String message) {
        String[] split = message.split(":");
        Long userId = Long.parseLong(split[0]);
        int points = Integer.parseInt(split[1]);
        userService.addPoints(userId,points);

        PointsLog pointsLog = new PointsLog();
        pointsLog.setUserId(userId);
        pointsLog.setPoints(points);
        pointsLogMapper.insert(pointsLog);
    }
}
