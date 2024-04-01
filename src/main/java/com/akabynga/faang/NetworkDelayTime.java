package com.akabynga.faang;

import java.util.*;

public class NetworkDelayTime {


    public static void main(String[] args) {

        int[][] times = {
                {1, 2, 9}, {1, 4, 2}, {2, 5, 1},
                {4, 2, 4}, {4, 5, 6}, {3, 2, 3},
                {5, 3, 7}, {3, 1, 5}};
        int k = 1;
        int n = 5;

        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        int[] distances = new int[n];
        Map<Integer, List<int[]>> adjacent = new HashMap<>();

        for (int i = 0; i < n; i++) {
            distances[i] = k - 1 == i ? 0 : Integer.MAX_VALUE;
            adjacent.put(i, new ArrayList<>());
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> distances[a]));
        heap.add(k - 1);
        for (int[] time : times) {
            adjacent.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]});
        }

        while (!heap.isEmpty()) {
            Integer current = heap.poll();
            List<int[]> adj = adjacent.get(current);
            for (int[] a : adj) {
                int neighboring = a[0];
                int weight = a[1];

                if (distances[current] + weight < distances[neighboring]) {
                    distances[neighboring] = distances[current] + weight;
                    heap.add(neighboring);
                }
            }
        }
        int max = 0;
        for (int distance : distances) {
            max = Math.max(max, distance);
        }

        return max != Integer.MAX_VALUE ? max : -1;
    }


}
