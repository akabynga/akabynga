package com.akabynga.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("bdfbba"));
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

    public static String longestPalindrome_manacher(String s) {
        StringBuilder sPrime = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sPrime.append(c).append("#");
        }
        System.out.println(sPrime);
        int n = sPrime.length();
        int[] palindromeRadii = new int[n];
        int center = 0;
        int radius = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < radius) {
                palindromeRadii[i] = Math.min(radius - i, palindromeRadii[mirror]);
            }

            while (i + 1 + palindromeRadii[i] < n &&
                    i - 1 - palindromeRadii[i] >= 0 &&
                    sPrime.charAt(i + 1 + palindromeRadii[i]) == sPrime.charAt(i - 1 - palindromeRadii[i])) {
                palindromeRadii[i]++;
            }

            if (i + palindromeRadii[i] > radius) {
                center = i;
                radius = i + palindromeRadii[i];
            }
        }

        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i];
                centerIndex = i;
            }
        }

        int startIndex = (centerIndex - maxLength) / 2;

        return s.substring(startIndex, startIndex + maxLength);
    }

    public static String longestPalindrome_notEfficient(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                String temp = s.substring(start, start + length);
                if (isPalindrome(temp)) {
                    return temp;
                }
            }
        }

        return "";
    }
//    public static String longestPalindrome(String s) {
//
//        String longestString = "";
//        int longest = 1;
//
//
//        for (int i = 0; i < s.length() - 1; i++) {
//
//            int additional = 1;
//            while (i - additional >= 0 && i + additional < s.length()) {
//                if (s.charAt(i - additional) == s.charAt(i + additional) && longestString.length() > additional) {
//                    longestString = s.substring(i - additional, i + additional + 1);
//                    longest = longestString.length();
//                    additional++;
//                } else {
//                    break;
//                }
//
//            }
//        }
//        return longestString;
//    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
