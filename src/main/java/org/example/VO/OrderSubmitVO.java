package org.example.VO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSubmitVO implements Serializable {
//     订单状态
        private String status;

        // 请求ID
        private String requestId;

        // 下载链接
        private String downloadUrl;

        // 下载链接的有效期
        private String expiry;




//    // 响应码: 200 成功, 其他错误码
//    private int code;
//
//    // 失败原因或成功信息
//    private String msg;
//
//    // 返回的数据内容
//    private OrderSubmitData data;
//
//    // 构造方法
//    public OrderSubmitVO(int code, String msg, OrderSubmitData data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//    }




//    @Data
//    // 嵌套类用于封装订单相关数据
//    public static class OrderSubmitData {
//
//        // 订单状态
//        private String status;
//
//        // 请求ID
//        private String requestId;
//
//        // 下载链接
//        private String downloadUrl;
//
//        // 下载链接的有效期
//        private String expiry;
//
//        // 构造方法
//        public OrderSubmitData(String status, String requestId, String downloadUrl, String expiry) {
//            this.status = status;
//            this.requestId = requestId;
//            this.downloadUrl = downloadUrl;
//            this.expiry = expiry;
//        }
//    }
}
