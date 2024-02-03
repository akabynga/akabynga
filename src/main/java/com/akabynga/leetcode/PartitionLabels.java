package com.akabynga.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));

    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int[] last = new int[127];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int latest = last[s.charAt(i)];
            while (i < latest) {
                if (last[s.charAt(i)] > latest) {
                    latest = last[s.charAt(i)];
                }
                i++;
            }
            result.add(latest - start + 1);
        }
        return result;
    }
}
