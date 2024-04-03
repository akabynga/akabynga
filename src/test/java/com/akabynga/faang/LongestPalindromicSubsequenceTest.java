package com.akabynga.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestPalindromicSubsequenceTest {
    @Test
    public void givenOneStrings_returnLongestPalindromicSubsequence() {

        // arrange
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();
        String text1 = "bbbab";
        int expected = 4;

        // act
        int result = solution.longestPalindromeSubseq(text1);

        // assert
        Assertions.assertEquals(expected, result);

    }
}
