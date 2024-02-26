package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.ListNode;

import java.util.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l1Current = l1;
        l1Current.next = new ListNode(9);

        l1Current = l1Current.next;
        l1Current.next = new ListNode(9);

        l1Current = l1Current.next;
        l1Current.next = new ListNode(9);

        l1Current = l1Current.next;
        l1Current.next = new ListNode(9);

        l1Current = l1Current.next;
        l1Current.next = new ListNode(9);

        l1Current = l1Current.next;
        l1Current.next = new ListNode(9);

        ListNode l2 = new ListNode(9);

        ListNode l2Current = l2;
        l2Current.next = new ListNode(9);

        l2Current = l2Current.next;
        l2Current.next = new ListNode(9);

        l2Current = l2Current.next;
        l2Current.next = new ListNode(9);

        print(l1);
        print(l2);
        print(addTwoNumbers_1(l1, l2));
        print(addTwoNumbers(l1, l2));
    }

    public static void print(ListNode list) {

        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode current = null;
        boolean addOne = false;
        while (l1 != null || l2 != null) {

            int value = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (addOne ? 1 : 0);

            if (value > 9) {
                value = value % 10;
                addOne = true;
            } else {
                addOne = false;
            }
            ListNode next = new ListNode(value);

            if (result == null) {
                result = next;
                current = next;
            } else {
                current.next = next;
                current = current.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (addOne) {
            current.next = new ListNode(1);
        }
        return result;
    }


    public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        return convertToList(getNumberFromList(l1) + getNumberFromList(l2));
    }

    public static ListNode convertToList(int number) {

        ListNode node = new ListNode();
        ListNode head = node;
        do {
            node.val = number % 10;
            node.next = new ListNode();
            node = node.next;
            number /= 10;
        } while (number != 0);

        return head;
    }

    public static int getNumberFromList(ListNode node) {
        int number = 0;
        int multiplier = 1;
        ListNode current = node;
        while (current != null) {
            number += current.val * multiplier;
            current = current.next;
            multiplier *= 10;
        }
        return number;
    }
}
