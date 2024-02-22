package com.shengkai.demo.service;

import com.shengkai.demo.mapper.coursedb.CourseEnrollmentMapper;
import com.shengkai.demo.mapper.coursedb.CourseMapper;
import com.shengkai.demo.mapper.userdb.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusinessService {

    private final CourseMapper courseMapper;
    private final CourseEnrollmentMapper courseEnrollmentMapper;
    private final UserMapper userMapper;


    public BusinessService(CourseMapper courseMapper, CourseEnrollmentMapper courseEnrollmentMapper, UserMapper userMapper) {
        this.courseMapper = courseMapper;
        this.courseEnrollmentMapper = courseEnrollmentMapper;
        this.userMapper = userMapper;
    }


    public Map<String, Object> getUserCourse(String userName) {
        Map<String, Object> userInfo = userMapper.selectUserByName(userName);
        // 获取用户名
        Integer userId = (Integer) userInfo.get("user_id");
        // 获取用户与课程注册关系
        List<Integer> userCourseIdList = courseEnrollmentMapper.selectUserCourseByUserId(userId);
        List<Map<String, Object>> userCourseList = new ArrayList<>();
        for (Integer courseId : userCourseIdList) {
            userCourseList.add(courseMapper.selectCourseById(courseId));
        }
        userInfo.put("courseList", userCourseList);
        return userInfo;
    }
}
