package com.smart4aviation.util;

public class SegmentTree {
    private final Node root;
    private final int size;
    private final int range;

    public SegmentTree(int[] data) {
        range = data.length;
        size = Utilities.nextPowerOfTwo(data.length) << 1;
        root = build(data, 0, range - 1);
    }

    private Node build(int[] data, int left, int right) {
        if (left == right) {
            return new Node(data[left]);
        }
        int mid = (left + right) / 2;
        return new Node(build(data, left, mid), build(data, mid + 1, right));
    }

    public long sum(int leftBoundary, int rightBoundary) {
        if (leftBoundary < 0 || rightBoundary > range) {
            throw new IndexOutOfBoundsException("Boundaries out of provided data length");
        }
        return sum(root, 0, range, leftBoundary, rightBoundary);
    }

    // l - queryLeftBoundary
    // r - queryRightBoundary
    // tl - currentLeftBoundary
    // tr - currentRightBoundary
    private long sum(Node node, int cl, int cr, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == cl && r == cr) {
            return node.value;
        }
        int mid = (cl + cr) / 2;
        return sum(node.left, cl, mid, l, Math.min(mid, r)) + sum(node.right, mid + 1, cr, Math.max(mid + 1, l), r);
    }

    public void print() {
        System.out.println("============");
        System.out.println("SegmentTree: ");
        System.out.println("size: " + size);
        System.out.println("range: " + range);
        System.out.println("tree: ");
        printPreorder(root);
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
