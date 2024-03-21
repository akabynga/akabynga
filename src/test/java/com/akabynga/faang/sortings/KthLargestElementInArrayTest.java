package com.akabynga.faang.sortings;

import com.akabynga.faang.KthLargestElementInArray;
import com.akabynga.faang.sorting.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthLargestElementInArrayTest {


    // Input: nums = [3,2,1,5,6,4], k = 2
    // Output: 5
    @Test
    public void positiveTest() {
        // arrange
        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;
        // act
        int output = KthLargestElementInArray.findKthLargest(array, k);

        // assert
        Assertions.assertEquals(5, output);
    }

    @Test
    public void findKthLargestTest_priorityQueue() {
        // arrange
        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;
        // act
        int output = KthLargestElementInArray.findKthLargest_PriorityQueue(array, k);

        // assert
        Assertions.assertEquals(5, output);
    }
}
