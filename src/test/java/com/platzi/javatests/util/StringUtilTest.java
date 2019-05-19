package com.platzi.javatests.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}