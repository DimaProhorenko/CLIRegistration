package com.dima.controllers;

import com.dima.views.MainMenuView;

public class MainMenuController {
    private MainMenuView view;

    public MainMenuController() {
        view = new MainMenuView();
        view.printHeader();
    }

    public void handleData() {
        int choice = view.getData();

        switch(choice) {
            case 1 -> {
                LoginController controller = new LoginController();
                controller.handleData();
            }
            case 2 -> {
                SignupController controller = new SignupController();
                controller.handleData();
            }
        }

    }
}
