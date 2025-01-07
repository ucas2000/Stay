package org.example.Handler.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.DTO.OrdersSubmitDTO;
import org.example.Handler.OrderRepository;
import org.example.Handler.OrderService;
import org.example.VO.OrderSubmitVO;
import org.example.common.StatusCode;
import org.example.entity.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/6
 */

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private Order order;
    @Autowired
    private OrderRepository orderRepository;


    /*
    1.从客户端请求中解析必要的参数并进行校验。
    2.将请求数据保存到数据库中的 order 表。
    3.根据请求和保存的数据构建订单的返回信息（包括状态、请求 ID、下载链接等）。
    4.使用 OrderSubmitVO 作为标准的返回格式，返回 JSON 格式的响应。
     */
    @Override
    public OrderSubmitVO submit(OrdersSubmitDTO ordersSubmitDTO){
        if (ordersSubmitDTO.getRequestId() == null || ordersSubmitDTO.getUserId() == null) {
            throw new IllegalArgumentException(String.valueOf(StatusCode.PARAM_ERROR));
        }
        // 1. 构造订单数据
        order = new Order();
        BeanUtils.copyProperties(ordersSubmitDTO, order);

        // 2. 向订单表插入数据
        order = orderRepository.save(order);


        String downloadUrl = "https://example.com/download/" + order.getId();  // 假设订单 ID 为下载链接的组成部分
        String expiry = "1h";  // 假设有效期为1小时
        // 构建返回数据对象
        OrderSubmitVO.OrderSubmitData orderSubmitData = new OrderSubmitVO.OrderSubmitData(
                "accepted",           // 订单状态
                ordersSubmitDTO.getRequestId(), // 请求 ID
                downloadUrl,          // 下载链接
                expiry                // 下载链接有效期
        );

        // 3. 返回插入的订单数据（封装返回结果）
        OrderSubmitVO orderSubmitVO = new OrderSubmitVO(200,"订单提交成功",orderSubmitData);

        return orderSubmitVO;
    }

    @Override
    public boolean deleteOrder(Order order) {
        return false;
    }

    @Override
    public Optional<Order> getOrderById(String orderId) {
        return Optional.empty();
    }
}
