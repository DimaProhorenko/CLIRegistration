package com.dima.views;

import com.dima.entities.User;
import com.dima.entities.prompts.*;
import com.dima.utils.Printer;

import java.util.*;

public class SignupView {
    private Scanner scanner = new Scanner(System.in);
    private List<Prompt> prompts = new ArrayList<>(List.of(new EmailPrompt()));
    public User getData() {
        Printer.printHeader("Signup");
        for (int i = 0; i < prompts.size(); i++) {
            System.out.println(prompts.get(i).getMsg());
        }
        return null;
    }
}
