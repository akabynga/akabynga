package com.akabynga.leetcode;

import edu.princeton.cs.introcs.In;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (Objects.equals(a.getValue(), b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue().compareTo(a.getValue());
        });

        priorityQueue.addAll(map.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = priorityQueue.poll();
            if (entry == null) {
                continue;
            }
            result[i] = entry.getKey();
        }
        return result;
    }
}
