package org.example.DTO;
import javax.validation.constraints.NotNull;

import jdk.jshell.Snippet;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/6
 */
@Data
public class OrdersSubmitDTO {
    @NotNull
    private String requestId;  // 映射到 request_id

    @NotNull
    private String userId;     // 映射到 user_id

    @NotNull
    private String action;     // 映射到 action

    @NotNull
    private ParametersDTO parameters;  // 包含具体参数的 DTO 类



    @Data
    // 内部静态类 ParametersDTO
    public static class ParametersDTO {

        @NotNull
        private String time;  // 映射到 time

        @NotNull
        private List<Double> area;  // 映射到 area, 需要是一个 4 元素的数组

        @NotNull
        private List<String> tags;  // 映射到 tags
    }
}
