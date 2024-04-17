package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordPatternTest {


    @Test
    public void givenPatternAndStringWithWords_returnIsMatchPattern() {

        // arrange
        WordPattern solution = new WordPattern();

        String pattern = "abba";
        String s = "dog dog dog dog";
        boolean expected = false;

        // act
        boolean result = solution.wordPattern(pattern, s);

        // assert
        Assertions.assertEquals(expected, result);

    }
}
