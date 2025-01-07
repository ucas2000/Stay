package org.example.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.entity.User;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/7
 */
public interface UserMapper {

    /**
     * @description:
     * @author: lyc 
     * @date: 2025/1/7 11:15
     * @param user
     * @return: 
     **/
    void insertUser(User user);

    /**
     * @description:
     * @author: lyc 
     * @date: 2025/1/7 19:45
     * @param idNumber
     * @return: 
     **/
    @Select("select * from user where id_number = #{idNumber}")
    int getByidNumber(String idNumber);

    /**
     * @description:
     * @author: lyc
     * @date: 2025/1/7 19:53
     * @param userParam
     * @return: 
     **/
    User login(User userParam);
}
