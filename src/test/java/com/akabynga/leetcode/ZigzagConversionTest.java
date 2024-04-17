package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZigzagConversionTest {


    @Test
    public void givenStringAndNumberOfRow_whenConvertToZigZag_thenGivenConvertedString() {

        // arrange
        ZigzagConversion solution = new ZigzagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";

        // act
        String result = solution.convert(s, numRows);

        // assert
        Assertions.assertEquals(expected, result);
    }
}
