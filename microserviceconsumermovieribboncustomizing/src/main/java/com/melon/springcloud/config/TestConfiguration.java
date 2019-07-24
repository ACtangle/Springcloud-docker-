package com.melon.springcloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName TestConfiguration
 * @Description 1:使用RibbonClient为特定name的Ribbon client自定义配置
 *              2:使用@RibbonClient的configuation属性，制定Ribbon的配置类
 *              可以使用配置来进行自定义配置或者全局配置
 * @Author melon
 * @Date 2019-07-25 01:28
 * @Version
 */


@Configuration
@RibbonClient(value = "mircroservice-provider-user",configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
