package com.dima.utils;

import java.util.regex.Pattern;

public class Utils {
    public static boolean patternMatches(String str, String pattern) {
        return Pattern.compile(pattern).matcher(str).matches();
    }

    public static boolean emailMatches(String email) {
        return patternMatches(email, Constants.EMAIL_REGEX);
    }
}
