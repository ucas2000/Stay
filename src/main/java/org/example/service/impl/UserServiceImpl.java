package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.DTO.UserLoginDTO;
import org.example.common.CustomException;
import org.example.common.StatusCode;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/7
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User userParam) {
        return userMapper.login(userParam);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(User userParam){
        int count =userMapper.getByidNumber(userParam.getIdNumber());
        if(count > 0){
            throw new CustomException("该账号已被注册");
        }
        String encryptedPassword = DigestUtils.md5DigestAsHex(userParam.getPassword().getBytes());
        userParam.setPassword(encryptedPassword);

        userMapper.insertUser(userParam);
    }
}
