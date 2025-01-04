package com.smart4aviation.util;

public class SegmentTree {
    private long[] tree;
    private final int size;
    private final int range;
    private final int startOfLastRow;

    public SegmentTree(int[] data) {
        this.range = data.length;
        this.startOfLastRow = Utilities.nextPowerOfTwo(data.length);
        this.size = this.startOfLastRow << 1;
        this.tree = new long[this.size];
        build(data);
    }

    private void build(int[] data) {
        for (int i = 0; i < range; i++) {
            tree[startOfLastRow + i] = data[i];
        }
        int row = startOfLastRow >> 1;
        int previousRow = startOfLastRow;
        while (row > 0) {
            for (int i = row; i < previousRow; i++) {
                tree[i] = tree[i << 1] + tree[(i << 1) + 1];
            }
            previousRow = row;
            row >>= 1;
        }
    }

    public long sum(int leftBoundary, int rightBoundary) {
        if (leftBoundary < 1 || rightBoundary > range) {
            throw new IndexOutOfBoundsException("Boundaries out of provided data length");
        }
        return sum(1, leftBoundary, rightBoundary, leftBoundary, rightBoundary);
    }

    private long sum(int i, int tl, int tr, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == tl && r == tr) {
            return tree[i];
        }
        int mid = (l + r) / 2;
        return sum(i << 1, l, mid, l, Math.min(mid, r)) + sum((i << 1) + 1, mid + 1, tr, Math.max(mid, l), r);
    }

    public void print() {
        System.out.println("============");
        System.out.println("SegmentTree: ");
        System.out.println("size: " + size);
        System.out.println("range: " + range);
        System.out.print("tree: ");
        for (int i = 0; i < size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
}
