package com.akabynga.leetcode;

public class AddBinary {

    public static void main(String[] args) {
        String a = "1111";
        String b = "1111";

        System.out.println(addBinary(a, b));
    }


    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;

        while (aPointer >= 0 || bPointer >= 0 || carry == 1) {

            if (aPointer >= 0) {
                carry += a.charAt(aPointer--) - '0';
            }

            if(bPointer >=0){
                carry += b.charAt(bPointer--) - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }

    public static String addBinary_1(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int largestString = Math.max(a.length(), b.length());
        char carry = '0';
        for (int i = 0; i < largestString; i++) {
            char firstStringChar = a.length() - 1 - i >= 0 ? a.charAt(a.length() - 1 - i) : '0';
            char secondStringChar = b.length() - 1 - i >= 0 ? b.charAt(b.length() - 1 - i) : '0';
            int sumResult = Integer.parseInt(String.valueOf(firstStringChar)) + Integer.parseInt(String.valueOf(secondStringChar)) +
                    Integer.parseInt(String.valueOf(carry));

            if (sumResult == 0) {
                sb.insert(0, '0');
                carry = '0';
            } else if (sumResult == 1) {
                sb.insert(0, '1');
                carry = '0';
            } else if (sumResult == 2) {
                sb.insert(0, '0');
                carry = '1';
            } else {
                sb.insert(0, '1');
                carry = '1';
            }
        }
        if (carry == '1') {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
