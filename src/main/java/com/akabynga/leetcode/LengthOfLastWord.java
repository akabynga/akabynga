package com.akabynga.leetcode;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {

        int counter = 0;
        int indexOfLastLetter = -1;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (indexOfLastLetter != -1) {
                if (s.charAt(i) != ' ') {
                    counter++;
                } else {
                    break;
                }
            } else if (s.charAt(i) != ' ') {
                indexOfLastLetter = i;
                counter++;
            }
        }

        return counter;
    }

    // public static int lengthOfLastWord(String s) {
    //     String[] sarr = s.split("\s");
    //     return sarr[sarr.length-1].length();
    // }
}
