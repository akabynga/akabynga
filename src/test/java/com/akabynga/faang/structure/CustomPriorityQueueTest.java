package com.akabynga.faang.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class CustomPriorityQueueTest {

    @Test
    public void givenEmptyPriorityQueue_thenGetSize_0() {

        // arrange
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>(Comparator.comparingInt(a -> a));

        // act
        int actualResult = priorityQueue.size();

        // assert
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void givenEmptyPriorityQueue_thenReturnIsEmptyFlag_expectedTrue() {

        // arrange
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>(Comparator.comparingInt(a -> a));

        // act
        boolean actualResult = priorityQueue.isEmpty();

        // assert
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void givenEmptyMinPriorityQueue_addedTenElements_thenReturnLowest() {

        // arrange
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>(Comparator.comparingInt(a -> a));

        priorityQueue.push(1000000);
        priorityQueue.push(10000000);
        priorityQueue.push(100000000);
        priorityQueue.push(10);
        priorityQueue.push(100);
        priorityQueue.push(1000);
        priorityQueue.push(10000);
        priorityQueue.push(100000);

        // act
        int actualResult = priorityQueue.peek();

        // assert
        Assertions.assertEquals(10, actualResult);
    }

    @Test
    public void givenEmptyPriorityQueue_addedTenElements_thenReturnRightSize() {

        // arrange
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>(Comparator.comparingInt(a -> -a));
        priorityQueue.push(1);
        priorityQueue.push(10);
        priorityQueue.push(100);
        priorityQueue.push(1000);
        priorityQueue.push(10000);
        priorityQueue.push(100000);
        priorityQueue.push(1000000);
        priorityQueue.push(10000000);
        priorityQueue.push(100000000);
        priorityQueue.push(1000000000);

        // act
        int actualResult = priorityQueue.size();

        // assert
        Assertions.assertEquals(10, actualResult);
    }

    @Test
    public void givenPriorityQueueWithFiveElements_thenPopElement() {

        // arrange
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>(Comparator.comparingInt(a -> -a));
        priorityQueue.push(1);
        priorityQueue.push(10);
        priorityQueue.push(20);
        priorityQueue.push(30);
        priorityQueue.push(40);

        // act
        int actualResult = priorityQueue.pop();
        // assert
        Assertions.assertEquals(40, actualResult);
    }

    @Test
    public void givenPriorityQueueWithFiveElements_thenPopFiveElements() {

        // arrange
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>(Comparator.comparingInt(a -> -a));
        priorityQueue.push(1);
        priorityQueue.push(10);
        priorityQueue.push(20);
        priorityQueue.push(30);
        priorityQueue.push(40);

        // act
//        System.out.println(priorityQueue.pop());
//        System.out.println(priorityQueue.pop());
//        System.out.println(priorityQueue.pop());
//        System.out.println(priorityQueue.pop());
        int actualResult = priorityQueue.pop();
        // assert
        Assertions.assertEquals(1, actualResult);
    }
}
