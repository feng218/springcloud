package com.yufeng.springcloud.service;

import com.yufeng.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/9/8.
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
    @Override
    public DeptClientService create(Throwable throwable)
    {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept)
            {
                return false;
            }

            @Override
            public Dept get(Long id)
            {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("该ID：" + id + "没有对应的信息，Consumer客户端提供的信息，此服务Provider已关闭");
                dept.setDb_source("no this database in mysql");
                return dept;
            }

            @Override
            public List<Dept> list()
            {
                return null;
            }
        };
    }
}
