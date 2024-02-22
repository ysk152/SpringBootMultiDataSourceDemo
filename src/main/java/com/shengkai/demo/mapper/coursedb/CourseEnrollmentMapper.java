package com.shengkai.demo.mapper.coursedb;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseEnrollmentMapper {
    List<Integer> selectUserCourseByUserId(Integer userId);
}
