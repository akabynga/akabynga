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
        return buildList(0, numberOfNodes);
    }

    public static ListNode buildList(int start, int end) {
        if (end - start < 0) {
            return null;
        }
        ListNode node = new ListNode(start);
        ListNode currentNode = node;
        for (int i = start + 1; i <= end; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        return node;
    }
}