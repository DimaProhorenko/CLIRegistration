package com.dima.entities.prompts;

public abstract class Prompt {
    private String msg;

    public Prompt(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public abstract boolean validate();
}
