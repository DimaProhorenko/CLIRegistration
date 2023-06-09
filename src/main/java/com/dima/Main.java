package com.dima;

import com.dima.controllers.MainMenuController;
import com.dima.database.DBConn;
import com.dima.models.SignupModel;
import com.dima.utils.AES;

public class Main {
    public static void main(String[] args) {
        DBConn.connect();
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.handleData();
    }
}
