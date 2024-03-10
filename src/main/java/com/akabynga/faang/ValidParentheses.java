package com.akabynga.faang;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {


    public static void main(String[] args) {
        String s = "{()[]{}}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                stack.addFirst('}');
            } else if (s.charAt(i) == '(') {
                stack.addFirst(')');
            } else if (s.charAt(i) == '[') {
                stack.addFirst(']');
            } else if (!stack.isEmpty() && stack.getFirst() == s.charAt(i)) {
                stack.removeFirst();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
