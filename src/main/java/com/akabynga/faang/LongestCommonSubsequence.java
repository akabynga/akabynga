package com.akabynga.faang;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();

        for (int i = s1.length - 1; i >= 0; i--) {
            for (int j = s2.length - 1; j >= 0; j--) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }
}
