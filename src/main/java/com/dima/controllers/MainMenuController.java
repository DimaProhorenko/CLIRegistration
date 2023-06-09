package com.dima.controllers;

import com.dima.views.MainMenuView;

public class MainMenuController {
    private MainMenuView view;

    public MainMenuController() {
        view = new MainMenuView();
        view.printHeader();
    }

    public void handleData() {
        int choice = -1;

        while (choice != 0) {
            choice = view.getData();
        }

    }
}
