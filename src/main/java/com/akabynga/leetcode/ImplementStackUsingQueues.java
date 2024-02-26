package com.akabynga.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        private int counter = 0;

        public MyStack() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
        }

        public void push(int x) {
            while (queue1.size() > 0) {
                queue2.add(queue1.poll());
            }
            queue1.add(x);
            while (queue2.size() > 0) {
                queue1.add(queue2.poll());
            }
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.size() == 0;
        }
    }
}
