package com.akabynga.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String[] args) {

        String string = "eceba";
        int k = 3;
        System.out.println(lengthOfLongestSubstringKDistinct(string, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String str, int numberOfDistinct) {

        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {

            int distance = right - left;
            if (distance > maxLength) {
                maxLength = distance;
            }

            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);
            if (map.size() > numberOfDistinct) {

                if (map.get(str.charAt(right)) >= 1) {
                    map.remove(str.charAt(right));
                } else {
                    map.put(str.charAt(left), map.get(str.charAt(left)) - 1);
                }
                left++;
            }
        }


        return maxLength;
    }
}
