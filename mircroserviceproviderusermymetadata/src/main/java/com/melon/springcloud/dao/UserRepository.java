package com.melon.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.melon.springcloud.pojo.User;

/**
 * @ClassName UserRepository
 * @Description
 * @Author melon
 * @Date 2019-07-23 11:34
 * @Version
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
