package com.melon.springcloud.feign;

import com.melon.springcloud.config.FeignConfiguration;
import com.melon.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName UserFeignClient
 * @Description
 * @Author melon
 * @Date 2019-07-26 00:04
 * @Version
 */

@FeignClient(name = "mircroservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 使用feign自带的注解RequestLine
     * 1.注意@FeignClient注解使用的是name
     * 2.注意接口方法变量使用feign.Param的@Param注解，而不是@PathVariable注解
     * 3.使用@RequstLine注解
     * @param id
     * @return
     */

    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);

}
