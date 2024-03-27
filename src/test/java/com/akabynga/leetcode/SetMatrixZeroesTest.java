package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SetMatrixZeroesTest {


    @Test
    public void given2DArrayWithZeroes_whenReplaceToZeroColsAndRowsWithZero() {
        // arrange
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        SetMatrixZeroes solution = new SetMatrixZeroes();

        // act
        solution.setZeroes(matrix);

        // assert
        Assertions.assertArrayEquals(expected, matrix);
    }
}
