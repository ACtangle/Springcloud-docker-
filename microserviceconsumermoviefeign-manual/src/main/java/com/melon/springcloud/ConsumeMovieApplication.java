package com.melon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumeMovieApplication
 * @Description
 * @Author melon
 * @Date 2019-07-23 12:10
 * @Version
 */

@SpringBootApplication
//@EnableFeignClients
public class ConsumeMovieApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumeMovieApplication.class, args);
    }

}
