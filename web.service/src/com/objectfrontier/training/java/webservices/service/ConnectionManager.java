package com.objectfrontier.training.java.webservices.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.objectfrontier.training.java.webservices.exception.AppException;
import com.objectfrontier.training.java.webservices.exception.ExceptionCodes;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class ConnectionManager {

    private static Connection connection = null;

    static HikariConfig config = new HikariConfig("/db.properties");
    static { config.setMaximumPoolSize(3); }
    static HikariDataSource ds = new HikariDataSource(config);

    public static Connection getConnection() throws SQLException, IOException {

       connection =  ds.getConnection();
       connection.setAutoCommit(false);
       return connection;
    }

    public static void releaseConnection(Connection con, boolean isSuccess) {

        try {
            if (isSuccess) {
                con.commit();
                con.close();
            } else {
                con.rollback();
                con.close();
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new AppException(ExceptionCodes.INTERNAL_SERVER_ERROR);
        }
    }
}
