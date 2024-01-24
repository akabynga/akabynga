package com.akabynga.cursera.algorithms.week1;

import java.util.*;

public class SocialNetworkConnection {

    static List<Log> logs = new ArrayList<>();

    static {
        logs.add(new Log(0, 1, "2015-08-14 18:00:00"));
        logs.add(new Log(1, 9, "2015-08-14 18:01:00"));
        logs.add(new Log(0, 2, "2015-08-14 18:02:00"));
        logs.add(new Log(0, 3, "2015-08-14 18:04:00"));
        logs.add(new Log(0, 4, "2015-08-14 18:06:00"));
        logs.add(new Log(0, 5, "2015-08-14 18:08:00"));
        logs.add(new Log(0, 6, "2015-08-14 18:10:00"));
        logs.add(new Log(0, 7, "2015-08-14 18:12:00"));
        logs.add(new Log(0, 8, "2015-08-14 18:14:00"));
        logs.add(new Log(1, 2, "2015-08-14 18:16:00"));
        logs.add(new Log(1, 3, "2015-08-14 18:18:00"));
        logs.add(new Log(1, 4, "2015-08-14 18:20:00"));
        logs.add(new Log(1, 5, "2015-08-14 18:22:00"));
        logs.add(new Log(2, 1, "2015-08-14 18:24:00"));
        logs.add(new Log(2, 3, "2015-08-14 18:26:00"));
        logs.add(new Log(2, 4, "2015-08-14 18:28:00"));
        logs.add(new Log(5, 5, "2015-08-14 18:30:00"));
    }

    public static void main(String[] args) {

        Set<Integer> uniquePersons = new HashSet<>();

        for (int i = 0; i < logs.size(); i++) {
            uniquePersons.add(logs.get(i).from);
            uniquePersons.add(logs.get(i).to);
        }
        WeightedQuickUnionLargestElement connection = new WeightedQuickUnionLargestElement(uniquePersons.size());
        System.out.println(calculateAllUnion(connection));
        System.out.println(connection.getLargest(1));
        System.out.println(Arrays.toString(connection.getLargestElements()));
    }

    private static String calculateAllUnion(WeightedQuickUnionLargestElement connections) {

        for (int i = 0; i < logs.size(); i++) {
            if (!connections.connected(logs.get(i).from, logs.get(i).to)) {
                connections.union(logs.get(i).from, logs.get(i).to);
            }
            if (connections.count() == 1) {
                return logs.get(i).timestamp;
            }
        }
        return "Not connected";
    }


    static class Log {
        int from;
        int to;
        String timestamp;

        Log(int from, int to, String timestamp) {
            this.from = from;
            this.to = to;
            this.timestamp = timestamp;
        }
    }
}
