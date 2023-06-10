package com.dima.models;

import com.dima.database.DBConn;
import com.dima.entities.User;
import com.dima.utils.DBConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    public boolean checkIfInfoCorrent(User user) {
        String sql = "SELECT * FROM %s WHERE %s = ? AND %s = ?"
                .formatted(DBConstants.TABLE_USERS,
                        DBConstants.COLUMN_USERS_USERNAME, DBConstants.COLUMN_USERS_PASSWORD);

        try(PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql)) {
            pstmt.setString(1, user.userName());
            pstmt.setString(2, user.password());
            System.out.println(pstmt);
            ResultSet results = pstmt.executeQuery();
            if (results.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}
