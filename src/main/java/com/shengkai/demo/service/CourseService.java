package com.shengkai.demo.service;

import com.shengkai.demo.mapper.coursedb.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CourseService {

    private final CourseMapper courseMapper;

    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public Map<String, Object> getCourseInformation(String title) {
        return courseMapper.selectCourseByTitle(title);
    }
}
