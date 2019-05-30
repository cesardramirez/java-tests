package com.platzi.javatests.numroman;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void convertArabicNumeralsToRomans_whenIsSuccess() {
        assertEquals("XXIV", RomanNumerals.convertArabicNumeralsToRomans(24));
        assertEquals("VI", RomanNumerals.convertArabicNumeralsToRomans(6));
        assertEquals("LV", RomanNumerals.convertArabicNumeralsToRomans(55));
        assertEquals("CDXCIX", RomanNumerals.convertArabicNumeralsToRomans(499));
        assertEquals("DCCLXXXV", RomanNumerals.convertArabicNumeralsToRomans(785));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertArabicNumeralsToRomans_whenIsWrong() {
        assertEquals("0", RomanNumerals.convertArabicNumeralsToRomans(0));
    }
}