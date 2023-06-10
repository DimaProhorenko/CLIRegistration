package com.dima.views;
import com.dima.entities.User;
import com.dima.entities.prompts.PasswordPrompt;
import com.dima.entities.prompts.Prompt;
import com.dima.entities.prompts.UserNamePrompt;
import com.dima.utils.Printer;

import java.util.*;
public class LoginView {
    private Scanner scanner = new Scanner(System.in);
    private Prompt[] prompts = {new UserNamePrompt(), new PasswordPrompt()};

    public User getData() {
        List<String> data = new ArrayList<>(prompts.length);
        Printer.printHeader("Login");
        for (Prompt prompt : prompts) {
            while (true) {
                System.out.println(prompt.getMsg());
                String result = scanner.nextLine();
                boolean isAcceptable = prompt.validate(result);
                if (isAcceptable) {
                    data.add(result);
                    break;
                } else {
                    prompt.printError();
                }
            }
        }

        return new User(data.get(0), null, data.get(1));
    }

    public void showSuccessPage() {
        Printer.printHeader("Successfully logged in");
    }

    public void showFailPage() {
        Printer.printHeader("Username or password is wrong!");
    }
}
