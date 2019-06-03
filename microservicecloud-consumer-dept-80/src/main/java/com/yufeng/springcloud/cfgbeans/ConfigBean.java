package com.yufeng.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//applicationContext.xml ---> @Configuration配置   ConfigBean = applicationContext.xml
@Configuration
public class ConfigBean
{
	@Bean
	@LoadBalanced //Ribbon 是客户端负载均衡的工具；
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	@Bean
	public IRule myRule()
	{
		return new RandomRule();
	}
}
