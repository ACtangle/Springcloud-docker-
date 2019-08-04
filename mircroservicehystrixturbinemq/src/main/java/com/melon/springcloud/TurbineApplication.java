package com.melon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @ClassName TurbineApplication
 * @Description
 * @Author melon
 * @Date 2019-08-04 15:31
 * @Version
 */

@SpringBootApplication
@EnableTurbineStream
public class TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class,args);
    }
}
