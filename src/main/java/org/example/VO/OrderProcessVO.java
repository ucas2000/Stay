package org.example.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProcessVO  implements Serializable {
    // 订单状态
    private String status;

    // 请求ID
    private String requestId;

}
