package com.yufeng.springcloud.controller;

import com.yufeng.springcloud.entities.Dept;
import com.yufeng.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/6/11.
 */
@RestController
public class DeptController
{
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/get/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return deptClientService.list();
    }
}
