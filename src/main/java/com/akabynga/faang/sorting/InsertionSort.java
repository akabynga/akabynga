package com.akabynga.faang.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {543, 1, 2, 4, 6, 1, 4, 43, 3, 21, 3, 5, 23, 7, 65, 0};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {


        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int j = 0;
                while (array[i] >= array[j]) {
                    j++;
                }
                int temp = array[i];
                System.arraycopy(array, j, array, j + 1, i - j);
                array[j] = temp;
            }
        }
    }
}
