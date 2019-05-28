package com.yufeng.springcloud.controller;

import com.yufeng.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2019/4/16.
 */
@RestController
public class DeptController_Consumer
{
    //private static final String RETURN_URL_PREFIX = "http://localhost:8001";
    private static final String RETURN_URL_PREFIX = "http://microservicecloud-dept"; //服务提供方的spring.application.name的配置

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(RETURN_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(RETURN_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/get/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return restTemplate.getForObject(RETURN_URL_PREFIX + "/dept/get/list", List.class);
    }
}
