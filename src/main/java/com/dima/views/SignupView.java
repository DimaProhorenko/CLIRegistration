package com.dima.views;

import com.dima.entities.User;
import com.dima.entities.prompts.*;
import com.dima.utils.Encryptor;
import com.dima.utils.Printer;

import java.util.*;

public class SignupView {
    private Scanner scanner = new Scanner(System.in);
    private Prompt[] prompts = {new UserNameDBPrompt(), new EmailDBPrompt(), new PasswordPrompt()};

    public User getData() {
        List<String> data = new ArrayList<>(prompts.length);

        Printer.printHeader("Signup");
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
        return new User(data.get(0), data.get(1), Encryptor.generateHashString(data.get(2)));
    }
}
