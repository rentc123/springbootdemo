package com.example.demo.bean;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataMap {

    private Map<String, String> map;

    //这里自动注入的时候会运行构造函数并把之前注入的PropertiesClass放到这个构造函数里。
    //不能自己去手工new一个DataMap(new PropertiesClass())，PropertiesClass new了也为空。
    public DataMap(PropertiesClass propertiesClass) {
        map = new HashMap<>();
        map.put("user_name", propertiesClass.getUsername());
        ConnectMySql(propertiesClass);
//        data.AddData();
    }

    public Map<String, String> getData() {
        return map;
    }

    public void ConnectMySql(PropertiesClass propertiesClass) {
        String selectsql = null;
        ResultSet retsult = null;
        final String url = propertiesClass.getUrl();
        final String name = propertiesClass.getDriver();
        final String user = propertiesClass.getUsername();
        final String password = propertiesClass.getPassword();

        Connection conn = null;
        PreparedStatement pst = null;

        selectsql = "select * from db_testtable";//SQL语句

        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(selectsql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            retsult = pst.executeQuery();//执行语句，得到结果集

            while (retsult.next()) {
                String c1 = retsult.getString(1);
                String c2 = retsult.getString(2);
                map.put(c1, c2);
            }//显示数据
            retsult.close();
            conn.close();//关闭连接
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


