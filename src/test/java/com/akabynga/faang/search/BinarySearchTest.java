package com.akabynga.faang.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {


    @Test
    public void binarySearchTest() {
        // arrange
        int[] array = {1, 1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchable = 8;

        // act
        int result = BinarySearch.binarySearch(array, searchable);
        System.out.println(result);

        // assert
        Assertions.assertEquals(10, result);
    }

    @Test
    public void binarySearchTest_recursion() {
        // arrange
        int[] array = {1, 1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchable = 8;

        // act
        int result = BinarySearch.binarySearch_recursion(array, searchable, 0, array.length - 1);
        System.out.println(result);

        // assert
        Assertions.assertEquals(10, result);
    }
}
