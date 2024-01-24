package com.akabynga.cursera.algorithms.week1;

public class Successor {
    private final int[] parent;   // parent[i] = parent of i
    private final int[] size;     // size[i] = number of elements in subtree rooted at i
    private int count;      // number of components

    private final int[] reals;


    public Successor(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        reals = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            reals[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public void remove(int p) {
        union(p, p + 1);
    }

    public int successor(int p) {
        return reals[find(p + 1)];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            reals[rootP] = rootQ;
        }
        count--;
    }

}
