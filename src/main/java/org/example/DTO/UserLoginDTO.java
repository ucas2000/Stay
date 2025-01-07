package org.example.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/7
 */

@Data
public class UserLoginDTO implements Serializable {
    private String code;
}
