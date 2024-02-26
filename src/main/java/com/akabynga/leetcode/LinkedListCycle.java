package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.ListNode;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode()));
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;

            if (head == fast) {
                return true;
            }
        }

        return false;
    }
}
