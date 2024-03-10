package com.akabynga.faang;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') {
                st.push(i);
            }
            if (sb.charAt(i) == ')') {
                if (!st.empty()) {
                    st.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        while (!st.empty()) {
            sb.setCharAt(st.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }
}
