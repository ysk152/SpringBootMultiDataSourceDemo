package com.shengkai.demo.service;

import com.shengkai.demo.mapper.userdb.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final UserMapper userMapper;

    // 使用构造函数注入 UserMapper
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Map<String,Object> getUserInformation(String userName) {
        return userMapper.selectUserByName(userName);
    }
}
