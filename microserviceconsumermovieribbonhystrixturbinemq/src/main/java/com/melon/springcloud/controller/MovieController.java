package com.melon.springcloud.controller;

import com.melon.springcloud.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "findIdFallback")
    @GetMapping("/user/{id}")
    public Object findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://mircroservice-provider-user/" + id, User.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("mircroservice-provider-user");
        //打印当前是哪个节点
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

    public User findIdFallback(Long id, Throwable throwable){
        log.error("进入回退方法，异常:",throwable);
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

}
