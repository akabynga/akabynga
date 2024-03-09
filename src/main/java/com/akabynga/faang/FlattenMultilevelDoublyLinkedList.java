package com.akabynga.faang;

import com.akabynga.leetcode.utils.MultilevelNode;

public class FlattenMultilevelDoublyLinkedList {

    public static void main(String[] args) {

    }

    public MultilevelNode flatten(MultilevelNode head) {

        MultilevelNode current = head;
        while (current != null) {
            if (current.child != null) {
                mergeChild(current, current.next);
            }
            current = current.next;
        }
        return head;
    }

    public void mergeChild(MultilevelNode parent, MultilevelNode lastNode) {

        parent.next = parent.child;
        parent.child.prev = parent;
        MultilevelNode current = parent.child;
        parent.child = null;
        while (current.next != null) {
            current = current.next;
        }
        current.next = lastNode;
        if (lastNode != null) {
            lastNode.prev = current;
        }

    }
}
