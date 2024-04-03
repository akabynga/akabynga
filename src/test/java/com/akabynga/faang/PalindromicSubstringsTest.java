package com.akabynga.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromicSubstringsTest {

    @Test
    public void givenOneString_findNumberOfPalindromicSubstring() {

        // arrange

        PalindromicSubstrings solution = new PalindromicSubstrings();

        String s = "aaa";
        int expected = 6;
        // act
        int actual = solution.countSubstrings(s);
        // assert
        Assertions.assertEquals(expected, actual);
    }
}
