package com.dima.entities.prompts;

import com.dima.utils.Utils;

public class EmailPrompt extends Prompt{
    private enum Errors {
        WRONG_INPUT("Wrong email format");
        String err;

        Errors(String err) {
            this.err = err;
        }
    }
    public EmailPrompt() {
        super("Enter your email: ");
    }

    @Override
    public boolean validate(String input) {
        if (!Utils.emailMatches(input)) {
            setError(Errors.WRONG_INPUT.err);
            return false;
        }
        return true;
    }
}
