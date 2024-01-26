package com.akabynga.cursera.algorithms.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF uf;
    private boolean[][] sites;
    private int virtualTop = 0;
    private int virtualBottom;
    private int size;
    private int openSites;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

        if (n <= 0) throw new IllegalArgumentException();
        this.size = n;
        virtualBottom = n * n + 1;
        sites = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        if (isOpen(row, col)) return;

        if (row == 1) {
            uf.union(index(row, col), virtualTop);
        } else if (row == size) {
            uf.union(index(row, col), virtualBottom);
        }

        // union possible neighbor(s)
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(index(row, col), index(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
            uf.union(index(row, col), index(row + 1, col));
        }
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(index(row, col), index(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
            uf.union(index(row, col), index(row, col + 1));
        }

        sites[row - 1][col - 1] = true;
        openSites++;
    }

    private int index(int row, int col) {
        return size * (row - 1) + col;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return sites[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) throw new IndexOutOfBoundsException();
        return uf.find(index(row, col)) == uf.find(virtualTop);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(virtualTop) == uf.find(virtualBottom);
    }

    private void validate(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("index out of bound exception");
        }
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}