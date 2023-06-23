package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    public void setUp() {
        //set up
        demoUtils = new DemoUtils();
    }

    @Test
    void testEqualsAndNotEquals() {
        int expected = 6;
        int unexpected = 8;

        //execute
        int actual = demoUtils.add(4, 2);

        //assert
        assertEquals(expected, actual, "4+2 must equals 6");
        assertNotEquals(unexpected, actual);

    }

    @Test
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "some example";

        assertNull(str1);
        assertNotNull(str2);
    }

}