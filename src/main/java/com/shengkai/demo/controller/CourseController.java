package com.shengkai.demo.controller;

import com.shengkai.demo.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/resource")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/getCourseInformation", method = RequestMethod.GET)
    public Map<String, Object> getCourseInformation(@RequestParam(value = "title") String title) {
        return courseService.getCourseInformation(title);
    }
}
