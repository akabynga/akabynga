package com.akabynga.leetcode.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode buildList(int numberOfNodes) {
        if (numberOfNodes < 0) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode currentNode = node;
        for (int i = 1; i <= numberOfNodes; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        return node;
    }
}