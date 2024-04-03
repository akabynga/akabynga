package com.akabynga.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumPathSumTest {

    @Test
    public void givenArray_returnMinPathSum() {

        // arrange
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int expectedResult = 7;

        // act
        int actualResult = solution.minPathSum(grid);

        // assert
        Assertions.assertEquals(expectedResult, actualResult);

    }
}
