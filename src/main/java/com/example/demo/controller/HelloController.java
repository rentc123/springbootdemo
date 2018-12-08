package com.example.demo.controller;

import com.example.demo.bean.PropertiesClass;
import com.example.demo.bean.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2018/10/23.
 */

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Word!!";
    }
    //一定要自动注入。不然找不到，初始化不了。
    @Autowired
    private PropertiesClass data;

    @Autowired
    private DataMap dataMap;

    @ResponseBody
    @RequestMapping("/dataMap")
    public String dataMap() {
//        Map<Integer,String> data=dataMap.getData();
        return ""+dataMap.getData();
    }

    @ResponseBody
    @RequestMapping("/dataMap/select/{id}")
    public String dataMapSelect(@PathVariable("id") String id) {
//        Map<Integer,String> data=dataMap.getData();
        return ""+dataMap.getData().get(id);
    }


}
