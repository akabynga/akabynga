package com.akabynga.faang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// solution - https://replit.com/@ZhangMYihua/N-Queens#index.js
public class _NQueens {


    private boolean isValid(List<Integer> colQueenPlacements) {
        if (colQueenPlacements.size() == 1) {
            return true;
        }

        int row = colQueenPlacements.size() - 1;
        int col = colQueenPlacements.get(row);

        for (var i = 0; i < colQueenPlacements.size() - 1; i++) {
            if (colQueenPlacements.get(i) == col) {
                return false;
            }
            if (row - i == Math.abs(colQueenPlacements.get(i) - col)) {
                return false;
            }
        }

        return true;
    }

    private List<String> generateSolution(int n, List<Integer> colQueenPlacements) {

        List<String> solution = new ArrayList<>();

        for (int row = 0; row < colQueenPlacements.size(); row++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (col == colQueenPlacements.get(row)) {
                    stringBuilder.append('Q');
                } else {
                    stringBuilder.append('.');
                }
            }
            if (solution.size() > row) {
                solution.set(row, stringBuilder.toString());
            } else {
                solution.add(row, stringBuilder.toString());
            }
        }

        return solution;
    }

    private void solve(int n, int currentRow, LinkedList<Integer> colQueenPlacements, List<List<String>> result) {
        if (currentRow == n) {
            result.add(generateSolution(n, colQueenPlacements));
        } else {
            for (int col = 0; col < n; col++) {
                colQueenPlacements.push(col);
                if (isValid(colQueenPlacements)) {
                    solve(n, currentRow + 1, colQueenPlacements, result);
                }
                if (!colQueenPlacements.isEmpty()) {
                    colQueenPlacements.pop();
                }
            }
        }
    }

    ;

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        solve(n, 0, new LinkedList<>(), result);

        return result;
    }
}
