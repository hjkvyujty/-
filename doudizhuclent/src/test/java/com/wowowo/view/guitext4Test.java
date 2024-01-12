package com.wowowo.view;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class guitext4Test {
    @Test
    void main() {

        try {
            // 1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载驱动成功!");

            // 2.连接数据库 获得连接对象 conn 是连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doudizhu?serverTimezone=UTC", "root", "1234");
            System.out.println("数据库连接成功！");

            // 3.创建执行环境
            Statement statement = conn.createStatement();

            // 4.创建了查询语句 进行语句的执行 得到结果
            ResultSet result = statement.executeQuery("select * from test");

            // 将查询到的东西进行展示
            while (result.next()) {
                System.out.println(result.getInt("id"));
                System.out.println(result.getString("username"));
                System.out.println(result.getString("password"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("加载驱动失败！");
            System.out.println("数据库连接失败！");
        }
    }

}