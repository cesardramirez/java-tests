package com.platzi.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        StringBuilder result = new StringBuilder();

        // Se debe eliminar el = para que los test funcionen.
        for (int i = 0; i <= times; i++) {
            result.append(str);
        }

        return result.toString();
    }
}
