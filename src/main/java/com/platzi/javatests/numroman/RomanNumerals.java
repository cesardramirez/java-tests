package com.platzi.javatests.numroman;

public class RomanNumerals {

    private final static String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final static int[] NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String convertArabicNumeralsToRomans(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(num + " no se puede transcribir a un números romano");
        }
        String romanValue = "";

        for (int i = 0; i < NUMBERS.length; i++) {
            while (num >= NUMBERS[i]) {
                romanValue = romanValue + ROMAN_NUMERALS[i];
                num = num - NUMBERS[i];
            }
        }
        return romanValue;
    }
}
