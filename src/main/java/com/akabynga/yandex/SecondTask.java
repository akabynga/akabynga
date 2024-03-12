package com.akabynga.yandex;

import java.util.Arrays;
import java.util.HashMap;

public class SecondTask {
    //    isVertSym([[0, 0], [0, 1], [1, 1], [2, 2], [3, 1], [4, 1], [4, 0]]) // true
    //    isVertSym([[0, 0], [0, 0], [1, 1], [2, 2], [3, 1], [4, 0], [4, 0]]) // true
    //    isVertSym([[0, 0], [0, 0], [1, 1], [2, 2], [3, 1], [4, 0]]) // false
    //    isVertSym([]) // true
    //    isVertSym([[0, 0]]) // true
    //    isVertSym([[0, 0], [10, 0]]) // true
    //    isVertSym([[0, 0], [11, 1]]) // false
    //    isVertSym([[0, 0], [1, 0], [3, 0]]) // false
    public static void main(String[] args) {
        System.out.println(hasVerticalSymLine(new Point[]{new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 2), new Point(3, 1), new Point(4, 1), new Point(4, 0)})); // true
        System.out.println(hasVerticalSymLine(new Point[]{new Point(0, 0), new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 1), new Point(4, 0), new Point(4, 0)}));// true
        System.out.println(hasVerticalSymLine(new Point[]{new Point(0, 0), new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 1), new Point(4, 0)}));// false
        System.out.println(hasVerticalSymLine(new Point[]{})); // true
        System.out.println(hasVerticalSymLine(new Point[]{new Point(0, 0)})); // true
        System.out.println(hasVerticalSymLine(new Point[]{new Point(0, 0), new Point(10, 0)})); // true
        System.out.println(hasVerticalSymLine(new Point[]{new Point(0, 0), new Point(11, 1)})); // false
        System.out.println(hasVerticalSymLine(new Point[]{new Point(0, 0), new Point(1, 0), new Point(3, 0)}));  // false
    }

    record Point(int x, int y) {
    }

    private static boolean hasVerticalSymLine(Point[] points) {

        int max = findMax(points);
        int min = findMin(points);
        double mid = (double) (max + min) / 2;
        HashMap<Point, Integer> map = new HashMap<>();

        for (Point p : points) {
            if (p.x == mid) {
                continue;
            }
            if (!map.containsKey(p)) {
                map.put(p, 1);
            }
            map.put(p, map.get(p) + 1);
        }

        for (Point p : map.keySet()) {
            int quantity = map.get(p);
            Point fPoint = new Point(max - (p.x - min), p.y);
            if (map.get(fPoint) == null || quantity != map.get(fPoint)) {
                return false;
            }
        }

        return true;
    }

    private static int findMax(Point[] points) {
        return Arrays.stream(points).mapToInt(p -> p.x).max().orElse(Integer.MAX_VALUE);
    }

    private static int findMin(Point[] points) {
        return Arrays.stream(points).mapToInt(p -> p.x).min().orElse(Integer.MIN_VALUE);
    }
}
