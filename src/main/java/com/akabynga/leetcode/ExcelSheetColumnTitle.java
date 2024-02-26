package com.akabynga.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {

//        int columnNumber = 28; // AB
        int columnNumber = 701;
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int columnNumber) {
        Map<Integer, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int additions = columnNumber % 26;
            sb.insert(0, (char) (additions + 'A'));
            columnNumber /= 26;
        }

        return sb.toString();
    }
}
