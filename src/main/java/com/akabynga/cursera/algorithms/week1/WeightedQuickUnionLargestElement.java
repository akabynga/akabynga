package com.akabynga.cursera.algorithms.week1;

public class WeightedQuickUnionLargestElement {
    private final int[] parent;   // parent[i] = parent of i
    private final int[] size;     // size[i] = number of elements in subtree rooted at i
    private final int[] largestElements;
    private int count;      // number of components

    public WeightedQuickUnionLargestElement(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        largestElements = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            largestElements[i] = i;
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

    @Deprecated
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public int getLargest(int p) {
        int rootP = find(p);
        if (rootP < largestElements.length) {
            return largestElements[rootP];
        }
        return -1;
    }

    public int[] getLargestElements() {
        return largestElements;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        if (largestElements[rootQ] < largestElements[rootP]) {
            largestElements[rootQ] = largestElements[rootP];
        } else {
            largestElements[rootP] = largestElements[rootQ];
        }

        count--;
    }

}
