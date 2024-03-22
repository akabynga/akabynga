package com.akabynga.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindFirstAndLastPositionElementSortedArrayTest {


    @Test
    public void givenSortedArray_findFirstAndLastPositionElementSortedArray_thenReturnStartAndEndPosition() {

        // arrange
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4};

        // act
        int[] result = FindFirstAndLastPositionElementSortedArray.searchRange(nums, target);

        // assert
        Assertions.assertArrayEquals(expected, result);

    }
}
