package com.example.demo.bean;


import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "db_testtable") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
public class User {

    @Id //这是一个主键
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自动主键

    private Integer id;

    @Column(name = "name", length = 50) //这是和数据表对应的一个列
    private String Name;

    //    @Column //省略默认列名就是属性名
//    private String email;
    public String getName() {
        return this.Name;
    }

}