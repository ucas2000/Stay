package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.DTO.OrdersSubmitDTO;
import org.example.service.OrderService;
import org.example.VO.OrderSubmitVO;
import org.example.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/6
 */
@RestController("userOrderController")
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public Result<OrderSubmitVO> submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO){
        log.info("用户下单,参数为:{}",ordersSubmitDTO);
        OrderSubmitVO ordersSubmitVO= orderService.submit(ordersSubmitDTO);
        return Result.success(ordersSubmitVO);
    }
}
