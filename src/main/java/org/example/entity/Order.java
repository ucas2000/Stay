package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.DTO.OrdersSubmitDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;                 // 订单唯一标识符，数据库主键
    private String requestId;        // 请求 ID
    private String userId;           // 用户 ID
    private String action;           // 操作类型
    private String createTime;             // 时间
    private List<Double> area;       // 区域列表
    private List<String> tags;       // 标签列表
    private String status;           // 订单状态（例如：待处理、已完成、失败等）


}