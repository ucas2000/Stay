package org.example.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.entity.Order;
/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/7
 */


public interface OrderMapper {

    /**
     * @description: 插入订单
     * @author: lyc
     * @date: 2025/1/7 11:11
     * @param order
     * @return:
     **/
    void insert(Order order);

    /**
     * @description:
     * @author: lyc 
     * @date: 2025/1/7 19:45
     * @param id
     * @return: 
     **/
    @Select("select * from order where request_Id = #{requestId}")
    Order selectById(String id);

    /**
     * @description:
     * @author: lyc
     * @date: 2025/1/7 20:57
     * @param ordersDB
     * @return:
     **/
    void update(Order ordersDB);
}
