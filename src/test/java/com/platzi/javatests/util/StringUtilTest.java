package com.platzi.javatests.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void testRepeatStringOnce() {
        assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void testRepeatStringMultipleTimes() {
        assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void testRepeatStringZeroTimes() {
        assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRepeatStringNegativeTimes() {
        StringUtil.repeat("hola", -1);
    }

    @Test
    public void testIsEmpty_whenStringIsNotEmpty() {
        assertFalse(StringUtil.isEmpty("abc"));
    }

    @Test
    public void testIsEmpty_whenStringIsOnlyBrackets() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void testIsEmpty_whenStringIsNull() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void testIsEmpty_whenStringIsOnlyWithEmptySpaces() {
        assertTrue(StringUtil.isEmpty("   "));
    }
}