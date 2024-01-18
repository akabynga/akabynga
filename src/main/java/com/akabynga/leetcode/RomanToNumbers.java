package com.akabynga.leetcode;

import java.util.HashMap;

public class RomanToNumbers {

    public static void main(String[] args) {


        System.out.println(romanToInt("MCMXCIV"));
    }


    public static int romanToInt(String s) {

        HashMap<Character, Integer> romanNumbers = new HashMap<>();

        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        int number = romanNumbers.getOrDefault(s.charAt(s.length() - 1), 0);

        for (int i = s.length() - 2; i >= 0; i--) {
            if (romanNumbers.containsKey(s.charAt(i)) && romanNumbers.containsKey(s.charAt(i + 1))) {
                if (romanNumbers.get(s.charAt(i)) > romanNumbers.get(s.charAt(i + 1))) {
                    number += romanNumbers.get(s.charAt(i));
                } else if (romanNumbers.get(s.charAt(i)) == romanNumbers.get(s.charAt(i + 1))) {
                    number += romanNumbers.get(s.charAt(i));
                } else {
                    number -= romanNumbers.get(s.charAt(i));
                }
            }
        }
        return number;
    }
}
