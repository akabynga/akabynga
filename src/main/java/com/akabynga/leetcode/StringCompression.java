package com.akabynga.leetcode;

import java.util.Arrays;

public class StringCompression {

    public int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();
        int left = 0;
        while (left < chars.length) {

            int counter = 1;
            int right = left + 1;
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
                counter++;
            }
            sb.append(chars[left]);
            left = right;
            if (counter != 1) {
                sb.append(counter);
            }
        }
        char[] compressedChars = sb.toString().toCharArray();
        System.arraycopy(compressedChars, 0, chars, 0, compressedChars.length);
        return sb.length();
    }
}
