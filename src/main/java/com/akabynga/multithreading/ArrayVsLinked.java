package com.akabynga.multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ArrayVsLinked {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 1_000_000; i++) {
            Integer integer = random.nextInt(1000);
            linkedList.add(integer);
            arrayList.add(integer);
        }
        long startTimeLinkedList = System.currentTimeMillis();
        for (Integer i : linkedList) {
            System.out.print(i);
            System.out.print(" ");
        }
        long endTimeLinkedList = System.currentTimeMillis();
        long timeElapsedLinkedList = endTimeLinkedList - startTimeLinkedList;

        long startTimeArrayList = System.currentTimeMillis();
        for (Integer i : arrayList) {
            System.out.print(i);
            System.out.print(" ");
        }
        long endTimeArrayList = System.currentTimeMillis();
        long timeElapsedArrayList = endTimeArrayList - startTimeArrayList;
        System.out.println();
        System.out.println("Linked List: " + timeElapsedLinkedList);
        System.out.println("Array List: " + timeElapsedArrayList);

    }
}
