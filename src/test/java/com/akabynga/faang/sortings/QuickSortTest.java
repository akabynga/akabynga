package com.akabynga.faang.sortings;

import com.akabynga.faang.sorting.MergeSort;
import com.akabynga.faang.sorting.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    public void positiveTest() {
        // arrange
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};

        // act
        QuickSort.quickSort(actual, 0, actual.length - 1);

        // assert
        Assertions.assertArrayEquals(expected, actual);
    }
}
