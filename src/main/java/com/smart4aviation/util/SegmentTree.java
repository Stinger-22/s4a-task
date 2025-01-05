package com.smart4aviation.util;

public class SegmentTree {
    private Node[] tree;
    private final int size;
    private final int range;

    public SegmentTree(int[] data) {
        this.range = data.length;
        this.size = Utilities.nextPowerOfTwo(data.length) << 1;
        this.tree = new Node[this.size];
        this.tree[0] = build(data, 0, range - 1);
    }

    private Node build(int[] data, int left, int right) {
        if (left == right) {
            return new Node(data[left]);
        }
        int mid = (left + right) / 2;
        return new Node(build(data, left, mid), build(data, mid + 1, right));
    }

    public long sum(int leftBoundary, int rightBoundary) {
        if (leftBoundary < 1 || rightBoundary > range) {
            throw new IndexOutOfBoundsException("Boundaries out of provided data length");
        }
        return sum(1, leftBoundary, rightBoundary, leftBoundary, rightBoundary);
    }

    // TODO rewrite for tree implementation
    private long sum(int i, int tl, int tr, int l, int r) {
        return 0;
//        if (l > r) {
//            return 0;
//        }
//        if (l == tl && r == tr) {
//            return tree[i];
//        }
//        int mid = (l + r) / 2;
//        return sum(i << 1, l, mid, l, Math.min(mid, r)) + sum((i << 1) + 1, mid + 1, tr, Math.max(mid, l), r);
    }

    public void print() {
        System.out.println("============");
        System.out.println("SegmentTree: ");
        System.out.println("size: " + size);
        System.out.println("range: " + range);
        System.out.println("tree: ");
        printPreorder(tree[0]);
        System.out.println();
    }

    private void printPreorder(Node node) {
        if (node == null) {
            System.out.println("back");
            return;
        }
        System.out.println(node.value + " ");
        System.out.println("left");
        printPreorder(node.left);
        System.out.println("right");
        printPreorder(node.right);
        System.out.println("back");
    }

    private static class Node {
        long value;
        Node left;
        Node right;

        public Node(long value) {
            this.value = value;
        }

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
            if (left != null) this.value += left.value;
            if (right != null) this.value += right.value;
        }
    }
}
