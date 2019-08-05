package com.melon.springcloud;

import com.melon.springcloud.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName ZuulApplication
 * @Description
 * @Author melon
 * @Date 2019-08-04 22:32
 * @Version
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    @Bean
    public PreRequestLogFilter preRequestLogFilter() {
        return new PreRequestLogFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
