package com.yufeng.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/8.
 * 注意: 必须实现序列化接口
 */

@AllArgsConstructor  //全参构造函数
@NoArgsConstructor   //无参构造函数
@Data      //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor的组合
@Accessors(chain = true)    //chain 若为true，则setter方法返回当前对象;
                            // fluent 若为true，则getter和setter方法的方法名都是属性名，且setter方法返回当前对象。
public class Dept implements Serializable
{
    private Long    deptno; // 主键
    private String  dname;  // 部门名称
    private String  dbSource;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(Long deptno)
    {
        this.deptno = deptno;
    }
}
