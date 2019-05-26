package com.yufeng.springcloud.controller;

import com.yufeng.springcloud.entities.Dept;
import com.yufeng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class DeptController
{
	@Autowired
    //@Resource(name = "deptServiceImpl")
	private DeptService service;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@RequestMapping(value = "/dept/get/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = discoveryClient.getServices(); //发现eureka中的微服务列表
		System.out.println("eureka中所有的微服务的name列表" + list);

		//从eureka中获取指定name的微服务的信息(yml中配置的spring.application.name)
		List<ServiceInstance> instances = discoveryClient.getInstances(list.get(0));
		for(ServiceInstance instance : instances)
		{
			System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t"
			+ instance.getPort() + "\t" + instance.getUri());
		}
		return this.discoveryClient;
	}
}
