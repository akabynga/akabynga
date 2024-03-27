package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransposeMatrixTest {


    @Test
    public void given2DMatrix_whenTransposed_thenReturnNewTransposedMatrix() {

        // arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        TransposeMatrix solution = new TransposeMatrix();

        // act
        int[][] result = solution.transpose(matrix);

        //assert
        Assertions.assertArrayEquals(expected, result);

    }
}
