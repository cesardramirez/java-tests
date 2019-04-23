package com.platzi.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++) {
            result.append(str);
        }

        return result.toString();
    }
}
