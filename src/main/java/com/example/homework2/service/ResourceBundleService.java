package com.example.homework2.service;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleService {
    static Locale locale = getLocale();
    public static ResourceBundle resourceBundle = ResourceBundle.getBundle("application", locale);

    public static String getLocalString(String content) {
        String value = resourceBundle.getString(content);
        return new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    private static Locale getLocale() {
        return System.getProperty("user.language").equals("uk") ? new Locale("uk") : new Locale("en");
    }
}
