package com.akabynga.faang;

import com.akabynga.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public static void main(String[] args) {

        ListNode cycledNode = new ListNode(3);
        ListNode head = new ListNode(1, new ListNode(2, cycledNode));
        cycledNode.next = head;

        ListNode detectedCycledNode = detectCycle_tortoise(head);
        if (detectedCycledNode != null) {
            System.out.println("Cycled: " + detectedCycledNode.val);
        } else {
            ListNode.print(head);
        }
    }

    // time: O(n)
    // space: O(1)
    public static ListNode detectCycle_tortoise(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (true) {

            tortoise = tortoise.next;
            hare = hare.next;

            if (hare == null || hare.next == null) {
                return null;
            } else {
                hare = hare.next;
            }

            if (tortoise == hare) {
                break;
            }
        }

        ListNode p1 = head;
        ListNode p2 = hare;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // space: O(n)
    // time: O(n)
    public static ListNode detectCycle_notOptimised(ListNode head) {

        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return current;
            }
            visited.add(current);
            current = current.next;
        }

        return null;
    }
}
