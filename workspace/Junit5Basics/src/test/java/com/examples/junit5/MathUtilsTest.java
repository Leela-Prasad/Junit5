package com.examples.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


class MathUtilsTest {

    private MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("Before All ...");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running " + testInfo.getTestMethod() + "with tags " + testInfo.getTags());
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Clean up ...");
    }

    @Nested
    @Tag("Math")
    class AddTest {

        @Test
        @DisplayName("Adding Positive Numbers")
        void addPositiveNumbers() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Adding Negative Numbers")
        void addNegativeNumbers() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            assertEquals(expected, actual);
        }

    }

    //@Test
    @RepeatedTest(3)
    @Tag("Circle")
    void computeCircleArea(RepetitionInfo repetitionInfo) {
        int repetitionNumber = repetitionInfo.getCurrentRepetition();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }


    @Test
    @Tag("Math")
    void divide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0));
    }

    @Test
    @Disabled
    void failTest() {
        fail();
    }

    @Test
    @Tag("conditional")
    void conditionalTest() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        System.out.println("Conditional Test Ran");
    }

    @Test
    @Tag("Math")
    void multiply() {
        assertAll(
                () -> assertEquals(2, mathUtils.multiply(1,2)),
                () -> assertEquals(0, mathUtils.multiply(0,2)),
                () -> assertEquals(9, mathUtils.multiply(3,3))
        );
    }
}