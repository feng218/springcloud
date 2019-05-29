package com.yufeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2019/4/8.
 */
@SpringBootApplication
@EnableEurekaClient     //本服务启动后自动注册到eureka中
@EnableDiscoveryClient  //服务的发现, 暴露出来
public class DeptProvider8002_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8002_App.class, args);
    }
}
