package com.dima.entities.prompts;

public class PasswordPromt extends Prompt{
    private enum Errors {
        LESS_THAN_MIN("Password must be greater than %d chars".formatted(MIN_LENGTH)),
        GREATER_THAN_MAX("Password must be less than %d chars".formatted(MAX_LENGTH));

        String errMsg;
        Errors(String errMsg) {
            this.errMsg = errMsg;
        }
    }
    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 16;
    private static final String PASSWORD_MSG = "Enter password (min - %d chars, max - %d chars)"
            .formatted(MIN_LENGTH, MAX_LENGTH);


    public PasswordPromt() {
        super(PASSWORD_MSG);
    }
    @Override
    public boolean validate(String input) {
        if (input.length() < MIN_LENGTH) {
            setError(Errors.LESS_THAN_MIN.errMsg);
            return false;
        }
        if (input.length() > MAX_LENGTH) {
            setError(Errors.GREATER_THAN_MAX.errMsg);
            return false;
        }
        return true;
    }
}
