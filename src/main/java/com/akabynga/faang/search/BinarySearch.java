package com.akabynga.faang.search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchable = 8;
        int index = binarySearch_recursion(array, searchable, 0, array.length - 1);
        System.out.println("Index: " + index + " value: " + array[index]);
    }

    public static int binarySearch_recursion(int[] array, int searchable, int left, int right) {

        int mid = (right + left) / 2;

        if (array[mid] == searchable) {
            return mid;
        } else if (array[mid] < searchable) {
            return binarySearch_recursion(array, searchable, mid + 1, right);
        } else {
            return binarySearch_recursion(array, searchable, left, mid - 1);
        }
    }

    public static int binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
