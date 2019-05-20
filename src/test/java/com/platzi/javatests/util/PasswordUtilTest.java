package com.platzi.javatests.util;

import org.junit.Test;

import static com.platzi.javatests.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.assertEquals;

public class PasswordUtilTest {

    @Test
    public void assessPasswordWeak_whenHasLessThanEightLetters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void assessPasswordWeak_whenHasOnlyLetters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void assessPasswordMedium_whenHasLettersAndNumbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void assessPasswordStrong_whenHasLettersNumbersAndSymbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd123#!"));
    }
}