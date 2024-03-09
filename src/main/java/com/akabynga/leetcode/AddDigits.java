package com.akabynga.leetcode;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {

        int number = num;
        int result = 0;
        while (number / 10 != 0 || number % 10 != 0) {
            result += number % 10;
            number /= 10;
        }

        return result > 9 ? addDigits(result) : result;
    }
}
