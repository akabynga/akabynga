package com.akabynga.collections.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class CopyDemo {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        Dog dog1 = new Dog("n1", 1);
        Dog dog2 = new Dog("n2", 1);
        Dog dog3 = new Dog("n3", 1);
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

//        LinkedList<Dog> dogLinkedList = new LinkedList<>(dogs.clone());
        // Collections.copy(dogLinkedList, dogs);
//        dogLinkedList.get(0).setAge(17);


        System.out.println(dogs.get(0).getAge());
    }

}
