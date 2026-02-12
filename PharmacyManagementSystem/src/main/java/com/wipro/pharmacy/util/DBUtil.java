package com.wipro.pharmacy.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "system";
    private static final String pass = "system";

    public static Connection getConnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            return DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            throw new RuntimeException("Database Connection Failed", e);
        }
    }
}