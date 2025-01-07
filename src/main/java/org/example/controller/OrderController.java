package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.DTO.OrdersSubmitDTO;
import org.example.VO.OrderProcessVO;
import org.example.service.OrderService;
import org.example.VO.OrderSubmitVO;
import org.example.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @description:
     * @author: lyc 
     * @date: 2025/1/7 20:45
     * @param ordersSubmitDTO
     * @return: 
     **/
    @PostMapping("/submit")
    public Result<OrderSubmitVO> submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO){
        log.info("用户下单,参数为:{}",ordersSubmitDTO);
        OrderSubmitVO ordersSubmitVO= orderService.submit(ordersSubmitDTO);
        return Result.success(ordersSubmitVO);
    }

    /**
     * @description:
     * @author: lyc 
     * @date: 2025/1/7 20:45
     * @param orderId
     * @return: 
     **/
    @GetMapping("/status/{orderId}")
    public Result<OrderProcessVO> getOrderStatus(@PathVariable String orderId){
        String requestId = orderId;  // 假设 request_id 就是 orderId
        String status = orderService.getOrderStatus(orderId);
        OrderProcessVO orderProcessVO = new OrderProcessVO(requestId,status);
        return Result.success(orderProcessVO);
    }

    /**
     * @description:
     * @author: lyc
     * @date: 2025/1/7 20:46
     * @param id
     * @return:
     **/
    @PutMapping("/cancel/{orderId}")
    public Result cancel(@PathVariable("id") String id) throws Exception {
        String status = orderService.userCancelById(id);
        OrderProcessVO orderProcessVO = new OrderProcessVO(id,status);
        return Result.success(orderProcessVO);
    }
}
