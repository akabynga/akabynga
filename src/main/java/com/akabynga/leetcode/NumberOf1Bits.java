package com.akabynga.leetcode;

public class NumberOf1Bits {


    public static void main(String[] args) {
        System.out.println(hammingWeight(Integer.MAX_VALUE));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        System.out.println(String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));
        return n == 0 ? 0 : (n & 1) + hammingWeight(n >>> 1);
    }


}
