package com.melon.springcloud.controller;

import com.melon.springcloud.dao.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.melon.springcloud.pojo.User;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description
 * @Author melon
 * @Date 2019-07-23 11:35
 * @Version
 */

@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Object findById(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        return user;
    }
}
