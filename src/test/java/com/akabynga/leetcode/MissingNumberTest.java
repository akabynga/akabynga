package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingNumberTest {

    @Test
    public void givenArrayWithMissingNumber_thenReturnMissingNumber() {

        // arrange
        MissingNumber solution = new MissingNumber();
        int[] nums = {3, 0, 1};
        int expected = 2;

        // act
        int result = solution.missingNumber(nums);

        // assert
        Assertions.assertEquals(expected, result);

    }
}
