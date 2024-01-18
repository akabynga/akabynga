package com.akabynga.multithreading.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class ArraySetExample {
    List<User> list;
    CopyOnWriteArraySet<User> cowSet;

    public ArraySetExample() {
        list = new ArrayList<User>();
        list.add(new User("������ "));
        list.add(new User("�������"));
        list.add(new User("������"));
        cowSet = new CopyOnWriteArraySet<User>(list);

        System.out.println("���� � ��������");

        Iterator<User> itr = cowSet.iterator();
        int cnt = 0;
        while (itr.hasNext()) {
            User user = itr.next();
            System.out.println("  " + user.name);
            if (++cnt == 2) {
                cowSet.add(new User("�����"));
                user.name += " ��������";
            }
        }

        System.out.println("\n���� ��� �������");
        itr = cowSet.iterator();
        while (itr.hasNext()) {
            User user = itr.next();
            System.out.println("  " + user.name);
        }
    }

    class User {
        private String name;

        public User(String name) {
            this.name = name;
        }
    }

    public static void main(String args[]) {
        new ArraySetExample();
    }
}