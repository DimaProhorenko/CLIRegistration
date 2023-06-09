package com.dima.utils;

public abstract class Constants {
//    APP SETTINGS (APP NAME)
    public static final String APP_NAME = "CLI Registration";


//    Output
    public static final String SEPARATOR = "-";
    public static final String INPUT_ERR_MSG = "Wrong input";

//    Regex
    public static final String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
}
