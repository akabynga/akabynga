package com.akabynga.faang;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {


    private static final int ROTTEN = 2;
    private static final int FRESH = 1;
    private static final int EMPTY = 0;

    private static final int[][] MOVEMENTS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {

        int minutes = 0;
        int fresh = 0;
        Queue<int[]> rottenOranges = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    rottenOranges.add(new int[]{i, j});
                }
                if (grid[i][j] == FRESH) {
                    fresh++;
                }
            }
        }

        int minuteRottens = rottenOranges.size();
        int tempRottens = 0;

        while (!rottenOranges.isEmpty()) {
            int[] rotten = rottenOranges.poll();
            minuteRottens--;

            for (int[] movement : MOVEMENTS) {
                if (rotten[0] + movement[0] >= 0 &&
                        rotten[1] + movement[1] >= 0 &&
                        rotten[0] + movement[0] < grid.length &&
                        rotten[1] + movement[1] < grid[0].length &&
                        grid[rotten[0] + movement[0]][rotten[1] + movement[1]] == 1) {
                    rottenOranges.add(new int[]{rotten[0] + movement[0], rotten[1] + movement[1]});
                    grid[rotten[0] + movement[0]][rotten[1] + movement[1]] = 2;
                    fresh--;
                    tempRottens++;
                }
            }

            if (minuteRottens == 0 && tempRottens == 0) {
                break;
            }

            if (minuteRottens == 0) {
                minuteRottens = tempRottens;
                tempRottens = 0;
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
