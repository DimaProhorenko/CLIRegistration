package com.dima.utils;

public abstract class Printer {

    public static void printHeader(String title) {
        printHeader(title, Constants.SEPARATOR);
    }
    public static void printHeader(String title, String separator) {
        System.out.println(separator.repeat(50));
        System.out.println(title);
        System.out.println(separator.repeat(50));
    }
}
