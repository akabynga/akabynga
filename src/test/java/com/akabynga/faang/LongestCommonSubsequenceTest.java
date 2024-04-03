package com.akabynga.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceTest {

    @Test
    public void givenTwoStrings_findMaxSumWithNonAdjacentIntegers() {

        // arrange
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int expected = 3;

        // act
        int result = solution.longestCommonSubsequence(text1, text2);

        // assert
        Assertions.assertEquals(expected, result);

    }
}
