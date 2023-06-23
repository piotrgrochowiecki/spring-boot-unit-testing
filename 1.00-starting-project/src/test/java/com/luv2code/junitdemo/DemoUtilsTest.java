package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

class DemoUtilsTest {

    @Test
    void testEqualsAndNotEquals() {
        //set up
        DemoUtils demoUtils = new DemoUtils();

        int expected = 6;

        //execute
        int actual = demoUtils.add(4, 2);

        //assert
        Assertions.assertEquals(expected, actual);

    }

}