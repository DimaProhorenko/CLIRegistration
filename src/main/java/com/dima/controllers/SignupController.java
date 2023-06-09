package com.dima.controllers;

import com.dima.entities.User;
import com.dima.models.SignupModel;
import com.dima.views.SignupView;

public class SignupController {
    private SignupView view;
    private SignupModel model;

    public SignupController() {
        view = new SignupView();
        model = new SignupModel();
    }

    public void handleData() {
        User user = view.getData();
        boolean isUserCreated = model.addUserToDB(user);
        if (isUserCreated) {
            System.out.println("User created");
        } else {
            System.out.println("User wasn't created");
        }
    }
}
