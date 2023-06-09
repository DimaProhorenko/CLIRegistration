package com.dima.entities.prompts;

import com.dima.utils.Utils;

public class EmailPrompt extends Prompt{
    public EmailPrompt() {
        super("Enter your email: ", "Wrong email format");
    }

    @Override
    public boolean validate(String input) {
        return Utils.emailMatches(input);
    }
}
