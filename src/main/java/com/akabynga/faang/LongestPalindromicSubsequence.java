package com.akabynga.faang;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestPalindromeSubseq(s, dp, 0, s.length() - 1);
    }

    private int longestPalindromeSubseq(String s, int[][] memo, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + longestPalindromeSubseq(s, memo, i + 1, j - 1);
        } else {
            memo[i][j] = Math.max(longestPalindromeSubseq(s, memo, i + 1, j), longestPalindromeSubseq(s, memo, 1, j - 1));
        }
        return memo[i][j];
    }
}
