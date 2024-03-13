package com.akabynga.faang.sorting;

import java.util.Arrays;

public class SelectionSort extends Sort {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 1, 4, 43, 3, 21, 3, 5, 23, 7, 65, 543};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            Sort.swap(array, min, i);
        }

    }
}
