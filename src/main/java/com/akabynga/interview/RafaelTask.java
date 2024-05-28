package com.akabynga.interview;

public class RafaelTask {

    //    There is an input string. Return the index of the first non-repetitive character. Return -1 if there are no such characters.
//
//    Example Inputs and Outputs:
//            - Input: "abbccd", Output: 0
//            - Input: "aabbcc", Output: -1
//            - Input: "aabcd", Output: 2
//            - Input: "aabbbbbcccccccccccccXaaa", Output: 20
    public static void main(String[] args) {
        String input = "aabbbbbcccccccccccccxaaa";
        System.out.println(solution_1(input));
    }

    public static int solution(String input) {
        if (input.length() == 1) {
            return 0;
        }
        int i = 0;
        while (i < input.length()) {

            char tempChar = input.charAt(i);
            int tempIndex = i;

            while (i < input.length() && input.charAt(i) == tempChar) {
                i++;
            }
            if (i == tempIndex + 1) {
                return tempIndex;
            }
        }
        return -1;
    }

    public static int solution_1(String input) {
        char[] arr = input.toCharArray();
        int[] freq = new int[26];
        for (char ch : arr) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (freq[ch - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
