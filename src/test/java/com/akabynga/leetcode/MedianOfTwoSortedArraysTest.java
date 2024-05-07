package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedianOfTwoSortedArraysTest {

    @Test
    public void initTwoSortedArraysReturnMedianOfMergedArrays() {

        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] array1 = {1, 2, 9, 10};
        int[] array2 = {-1, 0, 0, 2};

        double median = solution.findMedianSortedArrays(array1, array2);

        Assertions.assertEquals(1.5, median);
    }
}
