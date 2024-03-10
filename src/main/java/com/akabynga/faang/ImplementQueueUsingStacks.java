package com.akabynga.faang;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param2 = obj.pop();
        int param3 = obj.peek();
        boolean param4 = obj.empty();
        System.out.println(param2);
        System.out.println(param3);
        System.out.println(param4);
    }

    static class MyQueue {

        private final Stack<Integer> s1;
        private final Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s2.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int pop() {
            return s1.pop();
        }

        public int peek() {
            return s1.peek();
        }

        public boolean empty() {
            return s1.empty();
        }
    }
}
