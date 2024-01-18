package com.akabynga.leetcode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
//        list1 = [1,2,4], list2 = [1,3,4]
        ListNode a1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode a2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        System.out.println(mergeTwoLists(null, null));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode current = new ListNode();
        ListNode head = current;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                current.val = list1.val;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                current.val = list1.val;
                list1 = list1.next;
            } else {
                current.val = list2.val;
                list2 = list2.next;
            }
            if (list1 != null || list2 != null) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return head;
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
