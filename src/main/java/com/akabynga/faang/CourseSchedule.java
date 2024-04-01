package com.akabynga.faang;

import edu.princeton.cs.introcs.In;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // 1. initialization - indegree, adjacent nodes list
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjacentCourses = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adjacentCourses.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjacentCourses.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        // 2. initialize queue with nodes of in degree == 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 3. loop through each node, remove edges, if adjacent nodes have an in degree of 0 add to queue.
        int coursesCompleted = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesCompleted++;

            for (int adjacentCourse : adjacentCourses.get(course)) {
                inDegree[adjacentCourse]--;

                if (inDegree[adjacentCourse] == 0) {
                    queue.offer(adjacentCourse);
                }
            }
        }

        // 4. check if we have gone through all courses
        return coursesCompleted == numCourses;
    }

    public static boolean canFinish_withoutAdjacent(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            count++;
            for (int[] pair : prerequisites) {
                if (pair[1] == current) {
                    inDegree[pair[0]]--;
                    if (inDegree[pair[0]] == 0) {
                        stack.push(pair[0]);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static boolean canFinish_adjacentList(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjacent = IntStream.range(0, numCourses).boxed().collect(Collectors.toMap(i -> i, i -> new ArrayList<>()));

        for (int[] pair : prerequisites) {
            if (!adjacent.containsKey(pair[1])) {
                adjacent.put(pair[1], new ArrayList<>());
            }

            adjacent.get(pair[1]).add(pair[0]);
            inDegree[pair[0]]++;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            count++;
            for (Integer next : adjacent.get(current)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    stack.push(next);
                }
            }
        }

        return count == numCourses;
    }

    public static boolean canFinish_bruteforce(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < numCourses; i++) {
            int[] p = prerequisites[i];
            if (!adj.containsKey(p[1])) {
                adj.put(p[1], new ArrayList<>());
            }
            adj.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            Map<Integer, Boolean> visited = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>(adj.get(i));

            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited.put(current, true);

                if (current == i) {
                    return false;
                }
                List<Integer> adjacent = adj.get(current);
                for (int j = 0; j < adjacent.size(); j++) {
                    int next = adjacent.get(j);
                    if (!visited.containsKey(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        return true;
    }
}
