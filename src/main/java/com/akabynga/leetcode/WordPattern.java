package com.akabynga.leetcode;

import java.util.HashMap;

public class WordPattern {

    public static void main(String[] args) {
        WordPattern solution = new WordPattern();

        String pattern = "abba";
        String s = "dog cat cat fish";

        System.out.println(solution.wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] patterns = pattern.split("");
        String[] words = s.split(" ");

        HashMap<String, String> mapPatternToWord = new HashMap<>();
        HashMap<String, String> mapWordToPattern = new HashMap<>();

        if (patterns.length != words.length) {
            return false;
        }

        for (int i = 0; i < patterns.length; i++) {
            if (!mapPatternToWord.containsKey(patterns[i])) {
                mapPatternToWord.put(patterns[i], words[i]);
            }
            if (!mapWordToPattern.containsKey(words[i])) {
                mapWordToPattern.put(words[i], patterns[i]);
            }
            if (!mapPatternToWord.get(patterns[i]).equals(words[i]) || !mapWordToPattern.get(words[i]).equals(patterns[i])) {
                return false;
            }
        }
        return true;
    }
}
