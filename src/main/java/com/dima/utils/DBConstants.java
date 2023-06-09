package com.dima.utils;

public abstract class DBConstants {
    public static final String DB_NAME = "database.db";
    public static final String DB_BASE_URL = "src\\main\\resources\\database\\";
    public static final String DB_DRIVER = "jdbc:sqlite:";
    public static final String DB_CONNECTION_STRING = DB_DRIVER + DB_BASE_URL + DB_NAME;


    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERS_USERNAME = "username";
    public static final String COLUMN_USERS_EMAIL = "email";
    public static final String COLUMN_USERS_PASSWORD = "password";
    public static final String COLUMN_USERS_REGISTERED = "registered";
}
