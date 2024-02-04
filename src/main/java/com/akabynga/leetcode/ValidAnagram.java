package com.akabynga.leetcode;

public class ValidAnagram {
    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] letterCounters = new int[127];

        for (int i = 0; i < s.length(); i++) {
            letterCounters[s.charAt(i)]++;
            letterCounters[t.charAt(i)]--;
        }

        for (int i = 0; i < letterCounters.length; i++) {
            if (letterCounters[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
