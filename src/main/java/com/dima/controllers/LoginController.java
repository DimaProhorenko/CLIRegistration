package com.dima.controllers;

import com.dima.entities.User;
import com.dima.models.LoginModel;
import com.dima.views.LoginView;

public class LoginController {
    private LoginView view;
    private LoginModel model;

    public LoginController() {
        view = new LoginView();
        model = new LoginModel();
    }

    public void handleData() {
        User user = view.getData();
        if (model.checkIfInfoCorrent(user)) {
            view.showSuccessPage();
        } else {
            view.showFailPage();
        }
    }
}
