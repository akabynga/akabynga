package com.akabynga.interview;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Syberry {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        System.out.print(GameofLifeStrings(s.nextLine()));
        System.out.print(GameofLifeStrings("111_000_111_010"));
    }

    public static String GameofLifeStrings(String str) {

        for (int i = 0; i < 10; i++) {
            print(str);
            str = calculateNextGeneration(str);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return calculateNextGeneration(str);
    }


    private static void print(String str) {
        String[] array = str.split("_");
        System.out.println("------------------------");

        for (int i = 0; i < array[0].length() + 2; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (String string : array) {
            System.out.println("*" + string + "*");
        }
        for (int i = 0; i < array[0].length() + 2; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("------------------------");
    }

    private static String calculateNextGeneration(String str) {
        int[][] array = convertToArray(str);
        int[][] result = new int[array.length][array[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int numberOfAliveNeighbours = countAliveNeighbours(array, i, j);

                if (isAlive(array, i, j) == 1) {
                    // alive
                    if (numberOfAliveNeighbours < 2) {
                        // - Any live cell with fewer than two live neighbours dies, as if caused by under-population.
                        setDead(result, i, j);
                    } else if (numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3) {
                        // - Any live cell with two or three live neighbours lives on to the next generation.
                        setAlive(result, i, j);
                    } else {
                        setDead(result, i, j);
                    }
                    // - Any live cell with more than three live neighbours dies, as if by overcrowding.
                } else if (numberOfAliveNeighbours == 3) {
                    // dead
                    // - Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                    setAlive(result, i, j);
                }
            }
        }

        return convertToString(result);
    }

    public static int[][] convertToArray(String str) {
        if (str == null || str.isBlank()) {
            return new int[0][0];
        }
        // 000_111_000 -> [000, 111, 000] -> [[0,0,0][1,1,1][0,0,0]]
        return Arrays.stream(str.split("_"))
                .map(s -> Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }

    public static String convertToString(int[][] array) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]);
            }
            if (i != array.length - 1) {
                sb.append("_");
            }
        }
        return sb.toString();
    }

    public static void setAlive(int[][] array, int x, int y) {
        array[x][y] = 1;
    }

    public static void setDead(int[][] array, int x, int y) {
        array[x][y] = 0;
    }

    public static int isAlive(int[][] array, int x, int y) {
        return x >= 0 && x < array.length && y >= 0 && y < array[0].length && array[x][y] == 1 ? 1 : 0;
    }

    public static int countAliveNeighbours(int[][] array, int x, int y) {
        int result = 0;

        // top line
        result += isAlive(array, x - 1, y - 1);
        result += isAlive(array, x - 1, y);
        result += isAlive(array, x - 1, y + 1);

        // same line
        result += isAlive(array, x, y - 1);
        result += isAlive(array, x, y + 1);

        // bottom line
        result += isAlive(array, x + 1, y - 1);
        result += isAlive(array, x + 1, y);
        result += isAlive(array, x + 1, y + 1);

        return result;
    }
}
