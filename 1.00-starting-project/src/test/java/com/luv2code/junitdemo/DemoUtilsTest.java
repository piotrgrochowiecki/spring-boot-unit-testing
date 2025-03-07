package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
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

    @Test
    @DisplayName("Array equals test")
    void testArrayEquals() {
        String[] arrAtr = {"A", "B", "C"};

        assertArrayEquals(arrAtr, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays must be equal");

    }

    @Test
    @DisplayName("List equals test")
    void testListEquals() {
        List<String> expectedList = List.of("luv", "2", "code");

        assertIterableEquals(expectedList, demoUtils.getAcademyInList(), "Lists must be equal");
    }

    @Test
    @DisplayName("Lines match")
    void testLinesMatch() {
        List<String> expectedList = List.of("luv", "2", "code");

        assertLinesMatch(expectedList, demoUtils.getAcademyInList());
    }

    @Test
    @DisplayName("Throws and does not throw an exception")
    public void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-4));

        assertDoesNotThrow(() -> demoUtils.throwException(2));
    }

    @Test
    @DisplayName("Timeout test")
    public void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3L), () -> demoUtils.checkTimeout());
    }

    @Test
    @DisplayName("Test multiply")
    public void testMultiply() {
        assertEquals(12, demoUtils.multiply(2, 6));
    }

}