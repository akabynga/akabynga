package com.akabynga.faang.sortings;

import com.akabynga.faang.sorting.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void positiveTest() {
        // arrange
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};

        // act
        MergeSort.mergeSort(actual, actual.length);

        // assert
        Assertions.assertArrayEquals(expected, actual);
    }
}
