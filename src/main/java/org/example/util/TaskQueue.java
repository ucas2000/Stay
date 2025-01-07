package org.example.util;

import org.example.entity.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/6
 */
@Service
public class TaskQueue {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String TASK_QUEUE = "taskQueue";

    public void enqueueTask(Order task) {
        // 将任务信息发送到消息队列
        amqpTemplate.convertAndSend(TASK_QUEUE, task);
    }
}
