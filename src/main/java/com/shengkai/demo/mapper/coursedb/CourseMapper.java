package com.shengkai.demo.mapper.coursedb;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface CourseMapper {
    Map<String, Object> selectCourseByTitle(String title);

    Map<String, Object> selectCourseById(Integer courseId);


}
