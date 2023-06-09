package com.dima.entities.prompts;

public abstract class Prompt {
    private String msg;
    private String error;

    public Prompt(String msg, String error) {
        this.msg = msg;
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void printError() {
        System.out.println(error);
    }

    public abstract boolean validate(String input);
}
