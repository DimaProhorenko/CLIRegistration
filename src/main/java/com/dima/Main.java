package com.dima;

import com.dima.controllers.MainMenuController;
import com.dima.database.DBConn;
import com.dima.utils.Encryptor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBConn.connect();
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.handleData();
    }
}
