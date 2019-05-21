package com.platzi.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        StringBuilder result = new StringBuilder();

        if (times < 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }

        // Se debe eliminar el = para que los test funcionen.
        for (int i = 0; i < times; i++) {
            result.append(str);
        }

        return result.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0;
//        return str == null || str.trim().isEmpty();
//        return str == null || str.trim().equals("");
    }
}
