package org.example.service;

import org.example.DTO.OrdersSubmitDTO;
import org.example.VO.OrderProcessVO;
import org.example.VO.OrderSubmitVO;
import org.example.entity.Order;

import java.util.Optional;

/**
 * @Description
 * 该接口的主要功能是接收上游系统发送的订单任务，将其处理并加入到任务队列中，并通过分布式锁保证任务的唯一性，防止并发处理同一订单。
 * @Author: lyc
 * @Date: 2025/1/6
 */

public interface OrderService {
    // 创建订单
//    OrdersSubmitDTO createOrder(OrdersSubmitDTO ordersSubmitDTO);

    //提交订单
    OrderSubmitVO submit(OrdersSubmitDTO ordersSubmitDTO);

    //删除订单
    String userCancelById(String requestId);

    // 查询订单 by ID
    String getOrderStatus(String orderId);
}
