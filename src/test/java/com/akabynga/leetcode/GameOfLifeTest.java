package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

    @Test
    public void initBoardState_runGameOfLife_expectCorrectResult() {

        // arrange
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] result = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
        GameOfLife solution = new GameOfLife();

        // act
        solution.gameOfLife(board);

        // assert
        Assertions.assertArrayEquals(board, result);

    }
}
