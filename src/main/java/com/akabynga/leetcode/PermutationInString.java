package com.akabynga.leetcode;

// https://leetcode.com/problems/permutation-in-string/

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";

        System.out.println(checkInclusion(s2, s1));
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s2.length() > s1.length()) {
            return false;
        }

        int[] targetChars = new int[26];
        int[] sourceChars = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            targetChars[s2.charAt(i) - 'a']++;
            sourceChars[s1.charAt(i) - 'a']++;
        }
        if (isPermutation(sourceChars, targetChars)) {
            return true;
        }

        int left = 0;
        int right = s2.length() - 1;

        while (right < s1.length() - 1) {
            sourceChars[s1.charAt(left) - 'a']--;
            left++;
            right++;
            sourceChars[s1.charAt(right) - 'a']++;

            if (isPermutation(sourceChars, targetChars)) {
                return true;
            }
        }


        return false;
    }

    private static boolean isPermutation(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
