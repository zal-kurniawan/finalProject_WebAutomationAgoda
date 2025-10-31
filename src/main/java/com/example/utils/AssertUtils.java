package com.example.utils;

import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AssertUtils {
    private static final Logger log = LogManager.getLogger(AssertUtils.class);

    // -------------------------
    // HARD ASSERTIONS
    // -------------------------
    public static void assertEquals(String actual, String expected, String fieldName) {
        try {
            Assert.assertEquals(actual.trim(), expected.trim());
            log.info("✅ [{}] verified successfully — Expected: [{}], Actual: [{}]", fieldName, expected, actual);
        } catch (AssertionError e) {
            handleFailure(e, fieldName, expected, actual);
            throw e;
        }
    }

    private static void handleFailure(AssertionError e, String fieldName, String expected, String actual) {
        log.error("❌ Assertion failed for [{}] — Expected: [{}], Actual: [{}]", fieldName, expected, actual);
    }
}
