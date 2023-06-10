package com.dima.models;

import com.dima.database.DBConn;
import com.dima.entities.User;
import com.dima.utils.DBConstants;
import com.dima.utils.Encryptor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    public boolean checkIfInfoCorrent(User user) {
        String sql = "SELECT %s, %s FROM %s WHERE %s = ?"
                .formatted(DBConstants.COLUMN_USERS_USERNAME, DBConstants.COLUMN_USERS_PASSWORD, DBConstants.TABLE_USERS, DBConstants.COLUMN_USERS_USERNAME);

        try (PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql)) {
            pstmt.setString(1, user.userName());
            ResultSet results = pstmt.executeQuery();
            if (results.next()) {
                String dbPassword = results.getString(DBConstants.COLUMN_USERS_PASSWORD);
                return Encryptor.validatePassword(user.password(), dbPassword);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
