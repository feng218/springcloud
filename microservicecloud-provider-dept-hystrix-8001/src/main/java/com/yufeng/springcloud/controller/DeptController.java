package com.yufeng.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yufeng.springcloud.entities.Dept;
import com.yufeng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeptController
{
	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	//一旦调用服务方法失败抛出“错误信息后，胡自动范湖用@HystrixCommand标注好的fallbackMethod调用类中的指定方法”
	@HystrixCommand(fallbackMethod = "processHystrixGet")
	public Dept get(@PathVariable("id") Long id)
	{
		Dept dept = service.get(id);

		//模拟异常
		if(null == dept)
		{
			throw new RuntimeException("该id的信息不存在! id=" + id);
		}
		return service.get(id);
	}

	public Dept processHystrixGet(@PathVariable("id") Long id)
	{
		return new Dept().setDname("id没有对应的信息, null -- @HystrixCommand, id=" + id)
				.setDb_source("no this database in MySQL.");
	}

}
