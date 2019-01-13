package com.liang.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
@RequestMapping("/datasource")
@RefreshScope
public class DataSourceController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${mysql.test}")
    private String mark;

    @RequestMapping("/get")
    public String getDataSource() throws SQLException {


        System.out.println(dataSource.getConnection());

        System.out.println("==============>mark = "+mark);

        return dataSource.getConnection().toString();
    }

    @RequestMapping("/set")
    public String setData() throws SQLException {

        System.out.println(dataSource.hashCode());

        System.out.println("mark = "+mark);

        String executeSql = "insert into userinfo (username) values ('"+mark+"')";

        jdbcTemplate.execute(executeSql);

        return "ok";
    }
}
