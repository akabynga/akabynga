package com.akabynga.faang;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    private static final int[][] MOVEMENTS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        char[][] array = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(numIslands(array));
    }

    public static int numIslands(char[][] grid) {
        int counter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    bfs(grid, i, j);
                }
            }
        }
        return counter;
    }

    private static void bfs(char[][] grid, int row, int col) {

        grid[row][col] = '0';

        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            bfs(grid, row - 1, col);
        }
        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
            bfs(grid, row + 1, col);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            bfs(grid, row, col - 1);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
            bfs(grid, row, col + 1);
        }
    }

    public static int numIslands_2(char[][] grid) {
        int counter = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[][]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    counter++;
                    visitPoint(queue, grid, visited, i, j);

                    while (!queue.isEmpty()) {
                        int[][] point = queue.poll();

                        int row = point[0][0];
                        int col = point[0][1];

                        for (int[] movement : MOVEMENTS) {
                            if (row + movement[0] >= 0 && row + movement[0] < visited.length
                                    && col + movement[1] >= 0 && col + movement[1] < visited[0].length
                                    && !visited[row + movement[0]][col + movement[1]]) {
                                visitPoint(queue, grid, visited, row + movement[0], col + movement[1]);
                            }
                        }
                    }
                }
            }
        }

        return counter;
    }

    private static void visitPoint(Queue<int[][]> queue, char[][] grid, boolean[][] visitedMatrix, int row, int col) {
        if (grid[row][col] == '1') {
            queue.add(new int[][]{{row, col}});
            grid[row][col] = '0';
        }
        visitedMatrix[row][col] = true;
    }

    private static boolean needToCount(char[][] grid, int i, int j) {
        return i == 0 && j == 0 ||
                i == 0 && grid[i][j - 1] != '1' ||
                j == 0 && grid[i - 1][j] != '1' ||
                i != 0 && j != 0 && grid[i - 1][j] != '1' && grid[i][j - 1] != '1';
    }
}
