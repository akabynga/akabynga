package com.akabynga.leetcode;

public class ZigzagConversion {

    public String convert(String s, int numRows) {

        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int index = 0;
        int n = s.length();
        char[] chars = s.toCharArray();

        while (index < s.length()) {
            // go down
            for (int i = 0; i < numRows && index < s.length(); i++) {
                sbs[i].append(chars[index++]);
            }
            //go up
            for (int i = numRows - 2; i > 0 && index < s.length(); i--) {
                sbs[i].append(chars[index++]);
            }
        }
        StringBuilder result = sbs[0];
        for (int i = 1; i < numRows; i++) {
            result.append(sbs[i]);
        }

        return result.toString();
    }
}
