package com.akabynga.leetcode;

public class PalindromicSubstrings {

    public int countSubstrings_dp(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
            ans++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
                ans++;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1) && palindrome[i + 1][i + len - 2]) {
                    palindrome[i][i + len - 1] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += count(s, i, i);
            result += count(s, i, i + 1);
        }

        return result;
    }

    private int count(String s, int start, int end) {
        int count = 0;

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }

        return count;
    }

}
