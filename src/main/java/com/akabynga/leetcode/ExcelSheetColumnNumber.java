package com.akabynga.leetcode;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {

        System.out.println(titleToNumber("AAA"));
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
