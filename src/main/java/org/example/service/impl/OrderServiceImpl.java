package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.DTO.OrdersSubmitDTO;
import org.example.VO.OrderProcessVO;
import org.example.common.CustomException;
import org.example.mapper.OrderMapper;
import org.example.service.OrderService;
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
    private OrderMapper orderMapper;


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
        orderMapper.insert(order);

        String downloadUrl = "https://example.com/download/" + order.getId();  // 假设订单 ID 为下载链接的组成部分
        String expiry = "1h";  // 假设有效期为1小时
        // 构建返回数据对象
        OrderSubmitVO orderSubmitVO = new OrderSubmitVO(
                "accepted",           // 订单状态
                ordersSubmitDTO.getRequestId(), // 请求 ID
                downloadUrl,          // 下载链接
                expiry                // 下载链接有效期
        );


        return orderSubmitVO;
    }

    @Transactional
    @Override
    public String userCancelById(String requestId) {
        Order ordersDB = orderMapper.selectById(requestId);
        // 校验订单是否存在
        if (ordersDB == null) {
            throw new CustomException("订单不存在");
        }

        switch (ordersDB.getStatus()) {
            case "processing":
                // 执行取消操作
                ordersDB.setStatus("cancelled");
                orderMapper.update(ordersDB);
                return  "cancelled";
            case "completed":
                // 订单已经完成，不能取消
                return "completed";
            case "cancelled":
                // 订单已取消
                return "cancelled";
            default:
                // 其他情况
                return "cancel failed";
        }

    }



    @Override
    public String getOrderStatus(String orderId) {
        int maxRetry = 10;
        int retry = 0;

        while (retry < maxRetry) {
            order = orderMapper.selectById(orderId);
            if (order != null) {
                if(order.getStatus().equals("completed") || order.getStatus().equals("failed")){
                    return order.getStatus();
                }
                retry++;
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }else {
                throw new CustomException("订单不存在");
            }
        }
        return "processing";
    }
}
