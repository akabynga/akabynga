package com.akabynga.cursera.algorithms.week1;

public class BitonicSearch {
    public static void main(String[] args) {
        int arr[] = {6, 7, 8, 11, 9, 5, 2, 1};
        System.out.println(findBitonicPeak(arr, 1, arr.length - 2));
    }

    public static int findBitonicPeak(int[] array, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;

            if (array[mid - 1] < array[mid] && array[mid] > array[mid + 1]) {
                return mid;
            }

            if (array[mid] < array[mid + 1]) {
                return findBitonicPeak(array, mid + 1, right);
            } else {
                return findBitonicPeak(array, left, mid);
            }
        }
        return -1;
    }
}
