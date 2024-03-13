package com.akabynga.faang.sorting;

public class Sort {
    protected static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
