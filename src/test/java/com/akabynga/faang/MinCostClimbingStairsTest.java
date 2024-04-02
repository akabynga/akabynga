package com.akabynga.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinCostClimbingStairsTest {


    @Test
    public void givenCostArray_findCostClimbingStairs_thenReturnMinCost() {

        // arrange
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        int[] cost = {10, 15, 20};
        int expected = 15;

        // act
        int actual = solution.minCostClimbingStairs(cost);

        // assert
        Assertions.assertEquals(expected, actual);
    }
}