/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quoc.mathutil;

import com.quoc.mathutil.core.Mathutil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

/**
 *
 * @author ASUS PC
 */
public class MathUtilTest {

//    @Test
//    public void testGetFactorialGivenRightArgumentReturnWell() {
//        int n = 0;
//        long expected = 1;
//        long actual = Mathutil.getFactorial(n);
//
//        Assertions.assertEquals(expected, actual);
//        Assertions.assertEquals(1, Mathutil.getFactorial(1));
//        Assertions.assertEquals(2, Mathutil.getFactorial(2));
//        Assertions.assertEquals(6, Mathutil.getFactorial(3));
//        Assertions.assertEquals(24, Mathutil.getFactorial(4));
//        Assertions.assertEquals(120, Mathutil.getFactorial(5));
//        Assertions.assertEquals(720, Mathutil.getFactorial(6));
//
//    }
    @Test
    public void testGetFactorialGivenWrongArgumentThrowException() {
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Mathutil.getFactorial(-5)
        );

        Assertions.assertEquals(
                "n must be between 0 .. 20",
                exception.getMessage()
        );

    }

    //DDT
    public static Stream<Arguments> initData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(4, 24),
                Arguments.of(5, 120),
                Arguments.of(6, 720)
        );

    }

    @ParameterizedTest
    @MethodSource("initData")
    public void testGetFactorialGivenRightArgumentReturnWell(int input, int expected) {
        Assertions.assertEquals(expected, Mathutil.getFactorial(input));
    }

    @Test
    public void testGetFactorialGivenWrongArgumentThrowException2() {
        // test for negative input or input greater than 20
        int[] invalidInputs = {-1, -5, 21, 25};
        for (int input : invalidInputs) {
            Exception exception = Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> Mathutil.getFactorial(input)
            );

            Assertions.assertEquals(
                    "n must be between 0 .. 20",
                    exception.getMessage()
            );
        }

    }       
} 