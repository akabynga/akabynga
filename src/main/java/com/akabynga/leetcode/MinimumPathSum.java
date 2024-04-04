package com.akabynga.leetcode;

import java.util.Arrays;

public class MinimumPathSum {

    private static final int[][] MOVES = {{0, -1}, {-1, 0}};

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] array : dp) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                for (int[] move : MOVES) {
                    int prevRow = i + move[0];
                    int prevCol = j + move[1];
                    if (prevRow < grid.length && prevRow >= 0 &&
                            prevCol < grid[0].length && prevCol >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[prevRow][prevCol] + grid[i][j]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
