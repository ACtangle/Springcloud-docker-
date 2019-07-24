package com.melon.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RibbonConfiguration
 * @Description 该类为Ribbon的配置类，注意：该类并不在主应用程序上下文的的@ComponentScan所扫描的包中
 * @Author melon
 * @Date 2019-07-25 01:24
 * @Version
 */

@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule() {
        //负载均衡规则，改为随机
        return new RandomRule();
    }
}
