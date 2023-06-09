package com.dima.entities.prompts;

public class UserNamePrompt extends Prompt{
    private enum Errors {
        LESS_THAN_MIN("Username must be greater than %d chars".formatted(MIN_LENGTH)),
        GREATER_THAN_MAX("Username must be less than %d chars".formatted(MAX_LENGTH));
        String err;

        Errors(String err) {
            this.err = err;
        }
    }
    private static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 16;
    private static final String USERNAME_MSG = "Enter your username(at least %s chars, at most %s)".formatted(MIN_LENGTH, MAX_LENGTH);
    private static final String USERNAME_ERROR = "Length between %s - %s chars".formatted(MIN_LENGTH, MAX_LENGTH);
    public UserNamePrompt() {
        super(USERNAME_MSG);
    }

    @Override
    public boolean validate(String input) {
        if (input.length() < MIN_LENGTH) {
            setError(Errors.LESS_THAN_MIN.err);
            return false;
        }
        if (input.length() > MAX_LENGTH) {
            setError(Errors.GREATER_THAN_MAX.err);
            return false;
        }
        return true;
    }
}
