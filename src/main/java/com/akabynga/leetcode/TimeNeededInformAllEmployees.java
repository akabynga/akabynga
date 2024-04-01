package com.akabynga.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededInformAllEmployees {

    public static void main(String[] args) {
        int employeesQuantity = 7;
        int headID = 6;
        int[] managers = {1, 2, 3, 4, 5, 6, -1};
        int[] informTime = {0, 6, 5, 4, 3, 2, 1};
        int expected = 21;

        System.out.println("Number of minutes: " + numOfMinutes(employeesQuantity, headID, managers, informTime));
        System.out.println();
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (informTime[i] != 0) {
                res = Math.max(res, dfs(informTime, manager, i));
            }
        }
        return res;
    }

    private static int dfs(int[] informTime, int[] manager, int curr) {
        if (manager[curr] != -1) {
            informTime[curr] += dfs(informTime, manager, manager[curr]);
            manager[curr] = -1;
        }
        return informTime[curr];
    }

    public static int numOfMinutes_lessEfficient(int employeesQuantity, int headID, int[] managers, int[] informTime) {

        Map<Integer, List<Integer>> managersMapping = new HashMap<>();
        for (int i = 0; i < managers.length; i++) {
            if (managers[i] == -1) {
                continue;
            }

            if (!managersMapping.containsKey(managers[i])) {
                managersMapping.put(managers[i], new ArrayList<>());
            }

            managersMapping.get(managers[i]).add(i);
        }

        return dfs_lessEfficient(managersMapping, headID, informTime);
    }

    public static int dfs_lessEfficient(Map<Integer, List<Integer>> managersMapping, int managerId, int[] informTime) {

        if (managersMapping.get(managerId) == null) {
            return 0;
        }
        int maxTime = 0;
        for (Integer employeeId : managersMapping.get(managerId)) {
            maxTime = Math.max(maxTime, dfs_lessEfficient(managersMapping, employeeId, informTime));
        }

        return informTime[managerId] + maxTime;
    }
}
