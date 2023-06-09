package com.dima.database;

import com.dima.utils.DBConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static Connection conn;

    public static boolean connect() {
        try {
            conn = DriverManager.getConnection(DBConstants.DB_CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean close() {
        try {
            if (conn != null) {
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close db " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
