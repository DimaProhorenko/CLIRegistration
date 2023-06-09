package com.dima.controllers;

import com.dima.entities.User;
import com.dima.views.SignupView;

public class SignupController {
    private SignupView view;

    public SignupController() {
        view = new SignupView();
    }

    public void handleData() {
        User user = view.getData();
    }
}
