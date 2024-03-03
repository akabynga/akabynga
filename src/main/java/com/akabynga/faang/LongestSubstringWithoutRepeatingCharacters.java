package com.akabynga.faang;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring_Optimal(s));
    }

    public static int lengthOfLongestSubstring_Optimal(String s) {

        int[] seenChars = new int[128];
        int longestString = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            left = Math.max(seenChars[s.charAt(right)], left);
            longestString = Math.max(longestString, right - left + 1);
            seenChars[s.charAt(right)] = right + 1;
        }

        return longestString;
    }

    public static int lengthOfLongestSubstring_bruteForce(String s) {

        int maxLength = 0;
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (chars.contains(s.charAt(j))) {
                    break;
                } else {
                    chars.add(s.charAt(j));
                }
            }
            if (chars.size() > maxLength) {
                maxLength = chars.size();
            }
            chars.clear();
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> chars = new HashSet<>();

        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            if (right - left > max) {
                max = right - left;
            }
            if (chars.contains(s.charAt(right))) {
                left++;
            } else {
                chars.add(s.charAt(right));
            }
        }

        return max;
    }
}
