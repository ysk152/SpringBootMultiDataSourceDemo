package com.shengkai.demo.controller;

import com.shengkai.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    // 使用构造函数注入 UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUserInformation", method = RequestMethod.GET)
    public Map<String,Object> getUserInformation(@RequestParam(value = "userName") String userName) {
        return userService.getUserInformation(userName);
    }
}
