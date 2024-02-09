package com.akabynga.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        if (p.length() > s.length()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        int[] charsInTarget = new int[26];
        int[] charsInSource = new int[26];

        for (int i = 0; i < p.length(); i++) {
            charsInTarget[p.charAt(i) - 'a']++;
            charsInSource[s.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = p.length() - 1;

        if (isSame(charsInSource, charsInTarget)) {
            result.add(0);
        }
        while (right < s.length() - 1) {
            charsInSource[s.charAt(left) - 'a']--;
            left++;
            right++;
            charsInSource[s.charAt(right) - 'a']++;

            if (isSame(charsInSource, charsInTarget)) {
                result.add(left);
            }
        }

        return result;
    }

    public static boolean isSame(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
