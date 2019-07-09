package com.yufeng.springcloud;

import com.yufeng.myrule.CustomeRule;
import com.yufeng.springcloud.cfgbeans.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by Administrator on 2019/4/8.
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="microservicecloud-dept", configuration=ConfigBean.class)
public class DeptConsumer80_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
