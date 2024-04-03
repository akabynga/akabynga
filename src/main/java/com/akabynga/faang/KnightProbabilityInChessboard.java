package com.akabynga.faang;

public class KnightProbabilityInChessboard {


    private static final int[][] MOVES = {
            {-2, -1},
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2}
    };

    public double knightProbability(int n, int k, int row, int column) {
        double[][] prevDp = new double[n][n];
        double[][] currentDp = new double[n][n];

        prevDp[row][column] = 1;

        for (int step = 1; step <= k; step++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int i = 0; i < MOVES.length; i++) {

                        int[] dir = MOVES[i];
                        int prevRow = r + dir[0];
                        int prevCol = c + dir[1];
                        if (prevRow >= 0 && prevRow < n && prevCol >= 0 && prevCol < n) {
                            currentDp[r][c] = currentDp[r][c] + currentDp[prevRow][prevCol] / 8;
                        }
                    }
                }
            }
            prevDp = currentDp;
            currentDp = new double[n][n];
        }
        double result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += prevDp[i][j];
            }
        }
        return result;
    }

    public double knightProbability_recursive(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        return knightProbability_recursive(dp, n, k, row, column);
    }

    public double knightProbability_recursive(double[][][] dp, int n, int k, int row, int column) {
        if (row < 0 || column < 0 || row >= n || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[k][row][column] != 0) {
            return dp[k][row][column];
        }
        double result = 0;

        for (int i = 0; i < MOVES.length; i++) {
            int[] dir = MOVES[i];
            result += knightProbability_recursive(n, k - 1, row + dir[0], column + dir[1]);
        }

        return dp[k][row][column] += (result / 8);
    }


}
