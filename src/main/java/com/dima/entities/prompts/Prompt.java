package com.dima.entities.prompts;

import java.util.List;
import java.util.ArrayList;

public abstract class Prompt {
    private String msg;
    private String error;
    public Prompt(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void printError() {
        System.err.println(error);
    }

    public abstract boolean validate(String input);

}
