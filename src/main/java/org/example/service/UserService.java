package org.example.service;

import org.example.DTO.UserLoginDTO;
import org.example.entity.User;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/7
 */
public interface UserService {
    /**
     * @description:
     * @author: lyc 
     * @date: 2025/1/7 19:52
     * @param userParam
     * @return: 
     **/
    User login(User userParam);

    /**
     * @description:
     * @author: lyc 
     * @date: 2025/1/7 19:53
     * @param userParam
     * @return: 
     **/
    void register(User userParam);
}
