package com.yufeng.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//applicationContext.xml ---> @Configuration配置   ConfigBean = applicationContext.xml
@Configuration
public class ConfigBean
{
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
