package com.akabynga.faang;

import com.akabynga.leetcode.utils.ListNode;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildList(1, 5);
        ListNode.print(listNode);
        ListNode.print(reverseBetween(listNode, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        ListNode prev = null;

        for (int i = 0; i < left; i++) {
            prev = current;
            current = current.next;
        }

        ListNode preLeft = prev;
        ListNode leftNode = current;
        ListNode next = null;
        for (int i = left; i <= right; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        preLeft.next = prev;
        leftNode.next = current;

        return dummy.next;
    }
}
