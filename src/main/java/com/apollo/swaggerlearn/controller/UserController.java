package com.apollo.swaggerlearn.controller;

import com.apollo.swaggerlearn.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户模块说明")
@RestController
public class UserController {

    @RequestMapping("/getUser")
    public User getUser(){
        return new User();
    }
}
