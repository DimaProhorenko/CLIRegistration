package com.dima.models;

import com.dima.database.DBConn;
import com.dima.entities.User;
import com.dima.utils.DBConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class SignupModel {

    public boolean addUserToDB(User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ts = sdf.format(timestamp);

        String sql = "INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)"
                .formatted(
                        DBConstants.TABLE_USERS,
                        DBConstants.COLUMN_USERS_USERNAME,
                        DBConstants.COLUMN_USERS_EMAIL,
                        DBConstants.COLUMN_USERS_PASSWORD,
                        DBConstants.COLUMN_USERS_REGISTERED
                );
        try (PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql)) {
            pstmt.setString(1, user.userName());
            pstmt.setString(2, user.email());
            pstmt.setString(3, user.password());
            pstmt.setString(4, ts);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public static boolean userExists(String username) {
        boolean exists = false;
        String sql = "SELECT %s FROM %s WHERE %s = ? COLLATE NOCASE"
                .formatted(DBConstants.COLUMN_USERS_USERNAME,
                        DBConstants.TABLE_USERS, DBConstants.COLUMN_USERS_USERNAME);

        try (PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql)) {
            pstmt.setString(1 ,username);
            ResultSet results = pstmt.executeQuery();
            if (results.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return exists;
    }
}
