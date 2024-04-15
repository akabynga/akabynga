package com.akabynga.leetcode;

public class Trie {

    private final Node[] nodes;

    public Trie() {
        this.nodes = new Node[26];
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }
        int position = charAt(word, 0);

        if (nodes[position] == null) {
            nodes[position] = new Node();
            if (word.length() == 1) {
                nodes[position].end = true;
                return;
            }
        }
        insert(word, nodes[position], 1);
    }

    private void insert(String word, Node parent, int charNumber) {

        if (charNumber >= word.length()) {
            return;
        }
        int position = charAt(word, charNumber);
        if (parent.children[position] == null) {
            parent.children[position] = new Node();
        }

        if (word.length() == charNumber + 1) {
            parent.children[position].end = true;
            return;
        }

        insert(word, parent.children[position], ++charNumber);

    }

    public boolean search(String word) {

        if (word.isEmpty()) {
            return true;
        }
        int position = charAt(word, 0);
        if (nodes[position] == null) {
            return false;
        }
        return search(word, nodes[position], 1);
    }

    private boolean search(String word, Node parent, int charNumber) {
        if (charNumber >= word.length()) {
            return parent.end;
        }
        int position = charAt(word, charNumber);
        if (parent.children[position] == null) {
            return false;
        }
        return search(word, parent.children[position], ++charNumber);
    }

    private boolean startsWith(String prefix, Node parent, int charNumber) {
        if (charNumber >= prefix.length()) {
            return true;
        }
        int position = charAt(prefix, charNumber);
        if (parent.children[position] == null) {
            return false;
        }
        return startsWith(prefix, parent.children[position], ++charNumber);
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        int position = charAt(prefix, 0);
        if (nodes[position] == null) {
            return false;
        }
        return startsWith(prefix, nodes[position], 1);
    }

    private int charAt(String s, int pos) {
        return (int) (s.charAt(pos)) - (int) ('a');
    }


    private class Node {
        public boolean end;
        public final Node[] children;

        public Node() {
            this.children = new Node[26];
        }
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}