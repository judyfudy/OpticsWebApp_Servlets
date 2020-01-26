package com.bubnii.config;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn = null;

    public static synchronized Connection getConnection()
            throws NamingException, SQLException {

        if (conn == null) {
            conn = initConnection();
        }
        return conn;
    }

    private static Connection initConnection()
            throws NamingException, SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/opticadb?serverTimezone=UTC",
                "root",
                "567tyu567tyua");
    }
}
