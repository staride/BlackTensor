package com.blacktensor.stockWeb.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexUtilTest {

    @Test
    void isEmail() {
        String testData = "test@test.com";
        assertTrue(RegexUtil.isEmail(testData));
    }

    @Test
    void isEmailDataBlank() {
        String testData = " ";
        assertFalse(RegexUtil.isEmail(testData));
    }

    @Test
    void isEmailDataNotEmail() {
        String testData = "testData";
        assertFalse(RegexUtil.isEmail(testData));
    }

    @Test
    void isEmailDataNull() {
        String testData = null;
        assertFalse(RegexUtil.isEmail(testData));
    }
}