package com.melon.springcloud.controller;

import com.melon.springcloud.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.melon.springcloud.pojo.User;

import javax.annotation.Resource;
import java.util.Collection;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> collections = user.getAuthorities();
            for (GrantedAuthority ga: collections) {
                // 打印当前登录用户的信息
                UserController.LOGGER.info("当前用户是{}, 角色是{}", user.getUsername(), ga.getAuthority());
            }
        } else {
            UserController.LOGGER.warn("ε=(´ο｀*)))唉，出现问题了");
        }
        User findOne = userRepository.findOne(id);
        return findOne;
    }
}
