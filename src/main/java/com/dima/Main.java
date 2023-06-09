package com.dima;

import com.dima.controllers.MainMenuController;
import com.dima.database.DBConn;

public class Main {
    public static void main(String[] args) {
        DBConn.connect();
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.handleData();
    }
}
