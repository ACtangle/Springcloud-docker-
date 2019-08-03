package com.melon.springcloud.feign;

import com.melon.springcloud.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName UserFeignClient
 * @Description
 * @Author melon
 * @Date 2019-07-26 00:04
 * @Version
 */

//@FeignClient("mircroservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

}
