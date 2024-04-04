package com.akabynga.leetcode;

import java.util.*;

public class NetworkDelayTime {


    public static void main(String[] args) {

        int[][] times = {
                {1, 2, 1}, {2, 1, 3},
        };
        int k = 2;
        int n = 2;

        System.out.println(networkDelayTime_dijkstra(times, n, k));
        System.out.println(networkDelayTime_bellmanFord(times, n, k));
    }

    public static int networkDelayTime_bellmanFord(int[][] times, int n, int k) {
        long[] distances = new long[n];

        for (int i = 0; i < n; i++) {
            distances[i] = k - 1 == i ? 0 : Integer.MAX_VALUE;
        }

        for (int i = 0; i < n - 1; i++) {
            int count = 0;

            for (int[] time : times) {
                int source = time[0] - 1;
                int target = time[1] - 1;
                int weight = time[2];
                if (distances[source] + weight < distances[target]) {
                    distances[target] = distances[source] + weight;
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
        }

        long result = 0;
        for (long distance : distances) {
            result = Math.max(result, distance);
        }

        return result == Integer.MAX_VALUE ? -1 : (int) result;
    }

    public static int networkDelayTime_dijkstra(int[][] times, int n, int k) {

        int[] distances = new int[n];
        distances[k - 1] = 0;

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
