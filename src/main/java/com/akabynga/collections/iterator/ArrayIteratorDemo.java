package com.akabynga.collections.iterator;

public class ArrayIteratorDemo {
    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 6};
        ArrayIterator<Integer> iterator = new ArrayIterator<>(array);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        Box<Integer> box = new Box<>(array);

        for(Integer i : box){

        }
    }
}
