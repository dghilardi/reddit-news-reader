package org.ghilardi.newsreader.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class SqlUtilsTest {

    @Test
    public void verifyClampWithInputLengthHigherThanMaximum() {
        String in = "1234567890123";
        String clamped = SqlUtils.clampField("-", in, 10);
        assertEquals("1234567890", clamped);
    }

    @Test
    public void verifyClampWithInputLengthLowerThanMaximum() {
        String in = "123456";
        String clamped = SqlUtils.clampField("-", in, 10);
        assertEquals("123456", clamped);
    }

    @Test
    public void verifyClampWithInputLengthEqualsToMaximum() {
        String in = "1234567890";
        String clamped = SqlUtils.clampField("-", in, 10);
        assertEquals("1234567890", clamped);
    }

    @Test
    public void verifyClampDoesntExplodeOnNullInput() {
        String in = null;
        String clamped = SqlUtils.clampField("-", in, 10);
        assertEquals(null, clamped);
    }
}