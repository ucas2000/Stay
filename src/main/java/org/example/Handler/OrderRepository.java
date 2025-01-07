package org.example.Handler;

import org.example.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/6
 */
public interface OrderRepository extends JpaRepository<Order, Long>{
    Order findByRequestId(String requestId);
}
