package com.akabynga.faang;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class WallsAndGates {


    private static final int OPEN_ROOM = Integer.MAX_VALUE;
    private static final int WALL = -1;
    private static final int GATE = 0;

    private static final int[][] MOVEMENTS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public static void main(String[] args) {

        int[][] array = {
                {OPEN_ROOM, WALL, GATE, OPEN_ROOM},
                {OPEN_ROOM, OPEN_ROOM, OPEN_ROOM, WALL},
                {OPEN_ROOM, WALL, OPEN_ROOM, WALL},
                {GATE, WALL, OPEN_ROOM, OPEN_ROOM},
        };
        int[][] array1 = {
                {OPEN_ROOM, WALL, GATE, OPEN_ROOM},
                {OPEN_ROOM, OPEN_ROOM, OPEN_ROOM, WALL},
                {OPEN_ROOM, WALL, OPEN_ROOM, WALL},
                {GATE, WALL, OPEN_ROOM, OPEN_ROOM},
        };
        wallsAndGates_bfs(array);
        System.out.println(Arrays.deepToString(array));

        wallsAndGates_dfs(array1);
        System.out.println(Arrays.deepToString(array1));
    }

    private static int[][] wallsAndGates_dfs(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == GATE) {
                    dfs(array, i, j);
                }
            }
        }
        return array;
    }

    private static void dfs(int[][] array, int row, int col) {

        for (int[] movement : MOVEMENTS) {

            int newRow = row + movement[0];
            int newCol = col + movement[1];

            if (newRow >= 0 &&
                    newRow < array.length &&
                    newCol >= 0 &&
                    newCol < array[0].length &&
                    array[newRow][newCol] > array[row][col] + 1) {
                array[newRow][newCol] = array[row][col] + 1;
                dfs(array, newRow, newCol);
            }
        }

    }

    private static int[][] wallsAndGates_bfs(int[][] array) {

        Queue<int[]> gates = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == GATE) {
                    gates.add(new int[]{i, j});
                }
            }
        }

        bfs(array, gates);
        return array;
    }

    private static void bfs(int[][] array, Queue<int[]> gates) {
        while (!gates.isEmpty()) {
            int[] room = gates.poll();

            for (int[] movement : MOVEMENTS) {

                int newRow = room[0] + movement[0];
                int newCol = room[1] + movement[1];

                if (newRow >= 0 &&
                        newRow < array.length &&
                        newCol >= 0 &&
                        newCol < array[0].length &&
                        array[newRow][newCol] > array[room[0]][room[1]] + 1) {

                    gates.add(new int[]{newRow, newCol});
                    array[newRow][newCol] = array[room[0]][room[1]] + 1;
                }
            }
        }
    }

}
