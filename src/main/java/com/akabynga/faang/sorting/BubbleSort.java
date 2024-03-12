package com.akabynga.faang.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 1, 4, 43, 3, 21, 3, 5, 23, 7, 65, 543};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
