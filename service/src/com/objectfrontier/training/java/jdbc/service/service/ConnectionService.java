package com.objectfrontier.training.java.jdbc.service.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionService {

    private static Connection connection = null;

    static HikariConfig config = new HikariConfig("resources\\properties\\db.properties");
    static { config.setMaximumPoolSize(3); }
    static HikariDataSource ds = new HikariDataSource(config);

    public static Connection getConnection() throws SQLException, IOException {

       connection =  ds.getConnection();
        return connection;
    }
//    public static Connection getConnection() throws SQLException, IOException {
//
//        Properties dbProperty = new Properties();
//        ConnectionService connectionService = new ConnectionService();
//        Class<?> className = connectionService.getClass();
//        InputStream inputDb = className.getClassLoader().getResourceAsStream("db.properties");
//        dbProperty.load(inputDb);
//        Connection connection = DriverManager.getConnection(dbProperty.getProperty("jdbcUrl"), dbProperty.getProperty("username"), dbProperty.getProperty("password"));
//    }
}



