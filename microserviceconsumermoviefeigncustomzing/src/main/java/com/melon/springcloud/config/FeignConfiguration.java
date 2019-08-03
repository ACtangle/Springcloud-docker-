package com.melon.springcloud.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfiguration
 * @Description feign配置类
 * @Author melon
 * @Date 2019-07-29 17:23
 * @Version
 */

public class FeignConfiguration {

    /**
     * 将契约改为feign的默认契约，这样就可以使用feign自带的注解了
     * @return 默认的feign契约
     */

    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}
