package com.yufeng.springcloud.controller;

import com.yufeng.springcloud.entities.Dept;
import com.yufeng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class DeptController
{
	@Autowired
    //@Resource(name = "deptServiceImpl")
	private DeptService service;

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
}
