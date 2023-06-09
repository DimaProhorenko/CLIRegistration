package com.dima.entities.prompts;

import com.dima.utils.Utils;

public class EmailPrompt extends Prompt{
    private String email;
    public EmailPrompt() {
        super("Enter your email: ");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean validate() {
        return Utils.emailMatches(email);
    }
}
