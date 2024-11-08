package com.bhui.rocketmqdemo.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @author JXS
 */
public class SimpleProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 移除前导空格
        DefaultMQProducer producer = new DefaultMQProducer("bhui_producer");
        // 2.设置 NameServer 的地址
        producer.setNamesrvAddr("121.199.27.54:9876");
        producer.start();

        for (int i = 0; i < 1; i++) {
            Message message = new Message("Topic_bhui", "demo1", ("bhui mq测试" + i).getBytes(StandardCharsets.UTF_8));
            SendResult sendResult = producer.send(message);
            System.out.println("发送消息: " + message + " 发送结果: " + sendResult.toString());
        }

        producer.shutdown();
    }
}