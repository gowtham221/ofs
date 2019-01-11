package com.objectfrontier.training.java.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://pc1620:3306/gowtham_jayakumar", "gowtham_jayakumar", "demo");
        System.out.println(connection);

        if (connection != null) {
            log("%s", "Connected \n");
            return connection;
        } else {
            log("%s", "Connection cannot be established");
            return null;
        }
    }

    private static void log(String format, String vals) {
        System.out.format(format, vals);
    }
}

