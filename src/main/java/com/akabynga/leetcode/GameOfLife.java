package com.akabynga.leetcode;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int aliveNeighbours = countAliveNeighbours(board, i, j);

                if (isAlive(board, i, j)) {
                    if (aliveNeighbours < 2) {
                        setDead(result, i, j);
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        setAlive(result, i, j);
                    } else {
                        setDead(result, i, j);
                    }

                } else if (aliveNeighbours == 3) {
                    setAlive(result, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board[i].length);
        }
    }

    private int countAliveNeighbours(int[][] board, int x, int y) {
        int result = 0;

        // top line
        result += isAlive(board, x - 1, y - 1) ? 1 : 0;
        result += isAlive(board, x - 1, y) ? 1 : 0;
        result += isAlive(board, x - 1, y + 1) ? 1 : 0;

        // same line
        result += isAlive(board, x, y - 1) ? 1 : 0;
        result += isAlive(board, x, y + 1) ? 1 : 0;

        // bottom line
        result += isAlive(board, x + 1, y - 1) ? 1 : 0;
        result += isAlive(board, x + 1, y) ? 1 : 0;
        result += isAlive(board, x + 1, y + 1) ? 1 : 0;

        return result;
    }

    private boolean isAlive(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 1;
    }

    private void setAlive(int[][] board, int x, int y) {
        board[x][y] = 1;
    }

    private void setDead(int[][] board, int x, int y) {
        board[x][y] = 0;
    }
}
