package com.akabynga.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {

        String string = "eeeeeeeeeeeeeeeeeeceba";

        System.out.println(lengthOfLongestSubstringTwoDistinct(string));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            int distance = right - left;

            if (maxLength < distance) {
                maxLength = distance;
            }
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() > 2) {
                if (map.get(s.charAt(left)) == 1) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                left++;
            }
        }

        return maxLength;
    }
}
