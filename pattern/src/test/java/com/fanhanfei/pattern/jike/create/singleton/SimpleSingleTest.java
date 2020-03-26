package com.fanhanfei.pattern.jike.create.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.*;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("单例测试")
public class SimpleSingleTest {

    static Stream<Arguments> testGetProvider() {
        return Stream.of(
                arguments(2, 1, 100),
                arguments(3, 12, 100)
        );
    }

    @Test
    @DisplayName("饿汉模式")
    @MethodSource("testGetProvider")
    public void Simple() {
        long id = SimpleSingle.getInstance().getId();

    }

    @Test
    public void test() {

        try {
            Class.forName("com.mysql.jdbc.Driver");//加载及注册JDBC驱动程序
            String url = "jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";
            Connection con ;
            con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            String query = "select * from test";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                rs.getString(1);
                rs.getInt(2);
            }
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
