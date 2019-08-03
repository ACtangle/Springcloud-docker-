package com.melon.springcloud.config;

import com.melon.springcloud.dao.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomUserDetailService
 * @Description
 * @Author melon
 * @Date 2019-08-03 23:06
 * @Version
 */

@Component
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * 模拟两个账户
     * ① 账号是user，密码是password1，角色是user-role
     * ② 账号时候admin，密码是password1，角色是admin-role
     * @param username
     *                  用户名
     * @return
     *
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new SecurityUser("user", "password1", "user-role");
        } else if ("admin".equals(username)) {
            return new SecurityUser("admin", "password2", "admin-role");
        } else {
            return null;
        }
    }
}
