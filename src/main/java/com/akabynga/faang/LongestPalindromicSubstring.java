package com.akabynga.faang;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "babad";

        System.out.println(solution.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {

        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);

            String maxTemp = "";
            if (s1.length() > s2.length()) {
                maxTemp = s1;
            } else {
                maxTemp = s2;
            }
            if (max.length() < maxTemp.length()) {
                max = maxTemp;
            }
        }
        return max;
    }

    private String palindrome(String s, int start, int end) {

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }
}
