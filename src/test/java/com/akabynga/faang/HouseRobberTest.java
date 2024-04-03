package com.akabynga.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HouseRobberTest {

    @Test
    public void givenArrayOfIntegers_findMaxSumWithNonAdjacentIntegers() {

        // arrange
        HouseRobber solution = new HouseRobber();
        int[] nums = {1, 2, 3, 1};
        int expected = 4;

        // act
        int result = solution.rob(nums);

        // assert
        Assertions.assertEquals(expected, result);

    }

}
