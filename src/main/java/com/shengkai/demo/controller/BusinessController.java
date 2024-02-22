package com.shengkai.demo.controller;

import com.shengkai.demo.service.BusinessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/business")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @RequestMapping(value = "/getUserCourse", method = RequestMethod.GET)
    public Map<String, Object> getUserCourse(@RequestParam(value = "userName") String userName) {
        return businessService.getUserCourse(userName);
    }
}
