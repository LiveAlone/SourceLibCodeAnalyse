package org.yqj.source.demo.data.demo;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/4/7
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
public class DruidPoolDemo {

    public static void main(String[] args) {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("anywhere");
        dataSource.setName("localTest");

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from rule_info");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
            System.out.println(resultSet.toString());

            generatePoolInfo(dataSource);

            statement.close();
            connection.close();
        } catch (Exception e) {
            log.error("error gain connect :{}", e);
        }

        generatePoolInfo(dataSource);
    }

    private static void generatePoolInfo(DruidDataSource dataSource) {
        System.out.println(dataSource.getStatDataForMBean());
    }
}
