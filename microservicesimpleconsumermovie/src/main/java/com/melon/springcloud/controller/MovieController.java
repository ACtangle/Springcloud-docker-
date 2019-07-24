package com.melon.springcloud.controller;

import com.melon.springcloud.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName MovieController
 * @Description
 * @Author melon
 * @Date 2019-07-23 12:11
 * @Version
 */

@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public Object findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
    }
}
