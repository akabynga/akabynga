package com.akabynga.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String source = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(minWindow(source, target));
    }

    // A = 1, B = 1, C = 1, SIZE = 3, CURRENT_SIZE = 0, RIGHT = 0
    // A = 0, B = 1, C = 1, SIZE = 3, CURRENT_SIZE = 1, RIGHT = 0
    // A = 0, B = 0, C = 1, SIZE = 3, CURRENT_SIZE = 2, RIGHT = 3
    // A = 0, B = 0, C = 0, SIZE = 3, CURRENT_SIZE = 3, RIGHT = 5
    // A = 0, B = 0, C = 1, SIZE = 3, CURRENT_SIZE = 2, RIGHT = 3
    // A = 0, B = 0, C = 0, SIZE = 3, CURRENT_SIZE = 3, RIGHT = 3
    //        "ADOBECODEBANC"
    public static String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();


        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int storedLeft = 0;
        int storedRight = Integer.MAX_VALUE;
        int left = 0;
        int requiredChars = targetMap.size();

        for (int right = 0; right < s.length(); right++) {

            windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);

            if (targetMap.containsKey(s.charAt(right))
                    && Objects.equals(targetMap.get(s.charAt(right)), windowMap.get(s.charAt(right)))) {
                requiredChars--;
            }
            while (requiredChars == 0) {
                if (right - left < storedRight - storedLeft) {
                    storedRight = right;
                    storedLeft = left;
                }
                windowMap.put(s.charAt(left), windowMap.getOrDefault(s.charAt(left), 0) - 1);

                if (targetMap.containsKey(s.charAt(left))
                        && windowMap.get(s.charAt(left)) < targetMap.get(s.charAt(left))) {
                    requiredChars++;
                }
                left++;
            }
        }
        if (storedRight - storedLeft == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(storedLeft, storedRight + 1);
    }

}
