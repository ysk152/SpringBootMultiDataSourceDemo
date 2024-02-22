package com.shengkai.demo.mapper.userdb;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    Map<String, Object> selectUserByName(String userName);

}
