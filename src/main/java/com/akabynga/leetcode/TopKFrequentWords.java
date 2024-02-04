package com.akabynga.leetcode;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();

        HashMap<String, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (Objects.equals(a.getValue(), b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue().compareTo(a.getValue());
        });

        for (int i = 0; i < words.length; i++) {
            frequencyMap.put(words[i], frequencyMap.getOrDefault(words[i], 0) + 1);
        }
        priorityQueue.addAll(frequencyMap.entrySet());

        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = priorityQueue.poll();
            if (entry == null) {
                continue;
            }
            result.add(entry.getKey());
        }

        return result;
    }

}
