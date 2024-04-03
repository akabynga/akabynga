package com.akabynga.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {


    @Test
    public void givenArray_findLongestIncreasingSubsequence() {

        // arrange
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int expected = 4;

        // act
        int result = solution.lengthOfLIS(nums);

        // assert
        Assertions.assertEquals(expected, result);

    }
}
