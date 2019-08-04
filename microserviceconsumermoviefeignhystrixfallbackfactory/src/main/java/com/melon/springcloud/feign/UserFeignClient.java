package com.melon.springcloud.feign;

import com.melon.springcloud.pojo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
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

@FeignClient(name = "mircroservice-provider-user",fallbackFactory = UserFeignClient.FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);


    @Component
    class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

        private static final Logger log = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

        @Override
        public UserFeignClient create(Throwable throwable) {
            return new UserFeignClient() {
                @Override
                public User findById(Long id) {
                    //日志最好放在各个factory方法中
                    //否则就会在启动引用时打印日志
                    FeignClientFallbackFactory.log.info("fallback;reason was:",throwable);
                    User user = new User();
                    user.setId(-1L);
                    user.setName("默认用户");
                    return user;
                }
            };
        }
    }
}
