package com.melon.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName testController
 * @Description
 * @Author melon
 * @Date 2019-07-24 00:48
 * @Version
 */

@RestController
public class testController {

    @GetMapping("/test")
    public Object test() {
        return "sssss";
    }
}
