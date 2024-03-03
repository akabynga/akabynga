package com.akabynga.leetcode;

public class BattleshipsInBoard {
    public static void main(String[] args) {
        char[][] battlefield = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(countBattleships(battlefield));
    }

    public static int countBattleships(char[][] board) {

        int shipCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'X' || i != 0 && board[i - 1][j] == 'X' || j != 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                shipCount++;
            }
        }

        return shipCount;
    }
}
