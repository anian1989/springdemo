package com.springdb.demo;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.*;
import java.util.stream.Collectors;

/**
 * @author zhangjunshuai
 * @date 2020/3/26
 * @description
 **/
public class DriverTest {

    @Test
    public void test() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载及注册JDBC驱动程序
            String url = "jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";
            Connection con ;
            DriverManager.setLogWriter(new PrintWriter("file.txt"));
            DriverManager.println("开始喽………………");
            con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            String query = "select * from test";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                rs.getString(1);
                rs.getInt(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * InputStream 读取文件
     * 读取源文件
     */
    @Test
    public void test1(){
        // 获取config2.properties
        InputStream config2 = this.getClass().getResourceAsStream("/application.properties");

        String result = new BufferedReader(new InputStreamReader(config2))
                .lines().collect(Collectors.joining(System.lineSeparator()));
        // 获取config.properties
        System.out.println("测试： " + result);

    }
}
