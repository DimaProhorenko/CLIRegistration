package com.dima.entities.prompts;

public class UserNamePrompt extends Prompt{
    private static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 16;
    private static final String USERNAME_MSG = "Enter your username(at least %s chars, at most %s)".formatted(MIN_LENGTH, MAX_LENGTH);
    private static final String USERNAME_ERROR = "Length between %s - %s chars".formatted(MIN_LENGTH, MAX_LENGTH);
    public UserNamePrompt() {
        super(USERNAME_MSG, USERNAME_ERROR);
    }

    @Override
    public boolean validate(String input) {
        return input.length() >= MIN_LENGTH && input.length() <= MAX_LENGTH;
    }
}
