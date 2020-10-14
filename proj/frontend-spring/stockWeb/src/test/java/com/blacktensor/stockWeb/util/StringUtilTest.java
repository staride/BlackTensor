package com.blacktensor.stockWeb.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void isNotEmptyString() {
        String testData = "testData";
        assertTrue(StringUtil.isNotEmptyString(testData));
    }

    @Test
    void isNotEmptyStringDataBlank() {
        String testData = " ";
        assertFalse(StringUtil.isNotEmptyString(testData));
    }

    @Test
    void isNotEmptyStringDataNull() {
        String testData = null;
        assertFalse(StringUtil.isNotEmptyString(testData));
    }

    @Test
    void isEmptyStringDataNotEmpty() {
        String testData = "testData";
        assertFalse(StringUtil.isEmptyString(testData));
    }

    @Test
    void isEmptyStringDataBlack() {
        String testData = " ";
        assertTrue(StringUtil.isEmptyString(testData));
    }

    @Test
    void isEmptyStringDataNull() {
        String testData = null;
        assertTrue(StringUtil.isEmptyString(testData));
    }
}