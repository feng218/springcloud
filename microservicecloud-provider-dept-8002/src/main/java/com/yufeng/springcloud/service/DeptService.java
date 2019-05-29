package com.yufeng.springcloud.service;

import com.yufeng.springcloud.entities.Dept;

import java.util.List;


public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
