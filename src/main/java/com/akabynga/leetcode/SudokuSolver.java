package com.akabynga.leetcode;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {

        SudokuSolver solution = new SudokuSolver();

        char[][] sudoku = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(sudoku);
        System.out.println(Arrays.deepToString(sudoku));
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;

        boolean[][] boxes = new boolean[n][n];
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] != '.') {
                    int val = Character.getNumericValue(board[r][c]) - 1;

                    boxes[getBoxId(r, c)][val] = true;
                    rows[r][val] = true;
                    cols[c][val] = true;
                }
            }
        }
        solveBacktrack(board, boxes, rows, cols, 0, 0);
    }

    private boolean solveBacktrack(char[][] board, boolean[][] boxes, boolean[][] rows, boolean[][] cols, int r, int c) {
        if (r == board.length || c == board[0].length) {
            return true;
        }

        if (board[r][c] == '.') {
            for (int num = 1; num <= 9; num++) {

                board[r][c] = Character.forDigit(num, 10);

                boolean[] box = boxes[getBoxId(r, c)];
                boolean[] row = rows[r];
                boolean[] col = cols[c];

                if (isValid(box, row, col, num - 1)) {
                    box[num - 1] = true;
                    row[num - 1] = true;
                    col[num - 1] = true;

                    if (isSolvedBacktrack(board, boxes, rows, cols, r, c)) {
                        return true;
                    }
                    box[num - 1] = false;
                    row[num - 1] = false;
                    col[num - 1] = false;
                }
                board[r][c] = '.';
            }
        } else {
            return isSolvedBacktrack(board, boxes, rows, cols, r, c);
        }
        return false;
    }

    private boolean isSolvedBacktrack(char[][] board, boolean[][] boxes, boolean[][] rows, boolean[][] cols, int r, int c) {
        if (c == board[0].length - 1) {
            return solveBacktrack(board, boxes, rows, cols, r + 1, 0);
        } else {
            return solveBacktrack(board, boxes, rows, cols, r, c + 1);
        }
    }

    private boolean isValid(boolean[] box, boolean[] row, boolean[] col, int num) {
        return !(box[num] || row[num] || col[num]);
    }

    private int getBoxId(int row, int col) {
        double newRow = Math.floor((double) row / 3) * 3;
        double newCol = Math.floor((double) col / 3);
        return (int) (newRow + newCol);
    }
}
