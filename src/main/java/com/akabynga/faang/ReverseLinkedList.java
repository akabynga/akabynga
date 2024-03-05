package com.akabynga.faang;

import com.akabynga.leetcode.utils.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode head = ListNode.buildList(5);
        ListNode.print(head);

        ListNode.print(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

}
