package com.dima.controllers;

import com.dima.views.SignupView;

public class SignupController {
    private SignupView view;

    public SignupController() {
        view = new SignupView();
    }

    public void handleData() {
        view.getData();
    }
}
