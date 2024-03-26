package com.akabynga.faang.array2d;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Consumer;

public class Array2D<T> {


    private static final int[][] MOVEMENTS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public Array2D(T[][] array) {
        this.array = array;
    }


    private T[][] array;


    public static void main(String[] args) {
        Integer[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}};
        Array2D<Integer> array2D = new Array2D<>(array);

//        array2D.depthFirstTraversal(i -> System.out.println(i + " "));
        array2D.breadthFirstTraversal(i -> System.out.println(i + " "));
    }

    public void breadthFirstTraversal(Consumer<T> consumer) {
        boolean[][] visitedMatrix = new boolean[array.length][array[0].length];
        Queue<int[][]> queue = new ArrayDeque<>();

//        int[][] initialPoint = {{array.length / 2, array[0].length / 2}};
        int[][] initialPoint = {{0, 0}};
        visitPoint(queue, consumer, visitedMatrix, initialPoint[0][0], initialPoint[0][1]);

        while (!queue.isEmpty()) {
            int[][] point = queue.poll();

            int row = point[0][0];
            int col = point[0][1];


            for (int[] movement : MOVEMENTS) {
                if (!visitedMatrix[row + movement[0]][col + movement[1]] &&
                        row + movement[0] >= 0 && row + movement[0] < visitedMatrix.length
                        && col + movement[1] >= 0 && col + movement[1] < visitedMatrix[0].length) {
                    visitPoint(queue, consumer, visitedMatrix, row + movement[0], col + movement[1]);
                }
            }
        }
    }

    private void visitPoint(Queue<int[][]> queue, Consumer<T> consumer, boolean[][] visitedMatrix, int row, int col) {
        queue.add(new int[][]{{row, col}});
        consumer.accept(array[row][col]);
        visitedMatrix[row][col] = true;
    }

    public void depthFirstTraversal(Consumer<T> consumer) {
        boolean[][] visitedMatrix = new boolean[array.length][array[0].length];
        makeMovementDFS(consumer, visitedMatrix, 0, -1);
    }

    private void makeMovementDFS(Consumer<T> consumer, boolean[][] visitedMatrix, int row, int col) {
        for (int[] movement : MOVEMENTS) {

            if (row + movement[0] >= 0 && row + movement[0] < visitedMatrix.length
                    && col + movement[1] >= 0 && col + movement[1] < visitedMatrix[0].length
                    && !visitedMatrix[row + movement[0]][col + movement[1]]) {

                consumer.accept(array[row + movement[0]][col + movement[1]]);
                visitedMatrix[row + movement[0]][col + movement[1]] = true;
                makeMovementDFS(consumer, visitedMatrix, row + movement[0], col + movement[1]);
                return;
            }
        }
    }
}
