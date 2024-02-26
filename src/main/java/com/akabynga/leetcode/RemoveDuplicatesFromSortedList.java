package com.akabynga.leetcode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2))));
        print(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null) {

            while (current.next != null && current.val == current.next.val) {
                // remove
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }

    public static void print(ListNode list) {

        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

