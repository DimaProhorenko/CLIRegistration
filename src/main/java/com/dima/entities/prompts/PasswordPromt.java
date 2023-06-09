package com.dima.entities.prompts;

public class PasswordPromt extends Prompt{
    public static final int MIN_LENGTH = 6;
    public static final int MAX_LENGTH = 16;
    public static final String PASSWORD_MSG = "Enter password (min - %d chars, max - %d chars)"
            .formatted(MIN_LENGTH, MAX_LENGTH);
    public static final String PASSWORD_ERROR = "Password must be at least %d chars and at most %d chars"
            .formatted(MIN_LENGTH, MAX_LENGTH);
    public PasswordPromt() {
        super(PASSWORD_MSG, PASSWORD_ERROR);
    }
    @Override
    public boolean validate(String input) {
        return input.length() >= MIN_LENGTH && input.length() <= MAX_LENGTH;
    }
}
