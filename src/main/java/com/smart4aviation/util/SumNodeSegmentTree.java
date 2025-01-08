package com.smart4aviation.util;

import java.util.Arrays;

/**
 * <p><code>SegmentTree</code> implementation as-is, where each Node has reference to the left and right child.</p>
 * <p>This implementation of <code>SegmentTree</code> calculates sum over segment.</p>
 */
public class SumNodeSegmentTree implements SegmentTree {
    protected final int[] data;
    protected Node root;

    /**
     * <p>Constructs Segment Tree from the values provided in array.</p>
     * <p>Values from the given array are copied. Given array is not modified.</p>
     * @param data array which elements are used for construction.
     * @throws IllegalArgumentException if given array is null or have 0 length.
     */
    public SumNodeSegmentTree(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data cannot be null or empty");
        }
        this.data = Arrays.copyOf(data, data.length);
        this.root = build(data, 0, data.length - 1);
    }

    /**
     * <p>If <code>shareRoot = false</code>, creates independent copy of tree.</p>
     * <p>If <code>shareRoot = true</code>, creates new instance but <code>root</code> is shared among these 2 trees. In this case the user is responsible for appropriate handling of the trees.</p>
     * @param tree from which to copy.
     * @param shareRoot switch for creating trees with shared root if there is a need.
     * @throws IllegalArgumentException if given tree is null.
     */
    public SumNodeSegmentTree(SumNodeSegmentTree tree, boolean shareRoot) {
        if (tree == null) {
            throw new IllegalArgumentException("Provided tree can't be null");
        }
        this.data = Arrays.copyOf(tree.data, tree.data.length);
        if (shareRoot) {
            this.root = tree.root;
        }
        else {
            this.root = build(data, 0, data.length - 1);
        }
    }

    private Node build(int[] data, int left, int right) {
        if (left == right) {
            return new Node(data[left]);
        }
        int mid = (left + right) / 2;
        return new Node(build(data, left, mid), build(data, mid + 1, right));
    }

    /**
     * <p>Calculates sum of the numbers in a given segment.</p>
     * <p>Sum of data[leftBoundary; rightBoundary].</p>
     * @param leftBoundary {@inheritDoc}
     * @param rightBoundary {@inheritDoc}
     * @return sum of the numbers in the specified segment.
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public long query(int leftBoundary, int rightBoundary) {
        if (leftBoundary > rightBoundary) {
            throw new IllegalArgumentException("Specified left boundary is bigger than right boundary");
        }
        if (leftBoundary < 0 || rightBoundary >= data.length) {
            throw new IndexOutOfBoundsException("Boundaries out of provided data length");
        }
        return query(root, 0, data.length - 1, leftBoundary, rightBoundary);
    }

    /**
     * @see SumNodeSegmentTree#query(int, int)
     * @param node which represents current segment.
     * @param cl current segment left boundary.
     * @param cr current segment right boundary.
     * @param l left boundary of a query.
     * @param r right boundary of a query.
     * @return sum of the numbers in the specified segment.
     */
    private long query(Node node, int cl, int cr, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == cl && r == cr) {
            return node.value;
        }
        int mid = (cl + cr) / 2;
        return query(node.left, cl, mid, l, Math.min(mid, r)) + query(node.right, mid + 1, cr, Math.max(mid + 1, l), r);
    }

    @Override
    public void update(int position, int newData) {
        if (position < 0 || position >= data.length) {
            throw new IndexOutOfBoundsException("Position out of boundaries.");
        }
        root = update(root, 0, data.length - 1, position, newData);
    }

    /**
     * @see SumNodeSegmentTree#update(int, int)
     * @param node which represents current segment.
     * @param cl current segment left boundary.
     * @param cr current segment right boundary.
     * @param position index of the number to update.
     * @param newData new value for the number on given index.
     */
    private Node update(Node node, int cl, int cr, int position, int newData) {
        if (cl == cr) {
            return new Node(newData);
        }
        int mid = (cl + cr) / 2;
        if (position <= mid) {
            return new Node(update(node.left, cl, mid, position, newData), node.right);
        }
        else {
            return new Node(node.left, update(node.right, mid + 1, cr, position, newData));
        }
    }

    public String lastRow() {
        StringBuilder sb = new StringBuilder();
        lastRow(sb, root);
        return sb.toString();
    }

    private void lastRow(StringBuilder sb, Node node) {
        if (node == null) {
            return;
        }
        if ((node.left == null) & (node.right == null)) {
            sb.append(node.value).append(" ");
        }
        lastRow(sb, node.left);
        lastRow(sb, node.right);
    }

    public void printLastRow() {
        System.out.println(lastRow());
    }

    protected static class Node {
        protected long value;
        protected Node left;
        protected Node right;

        public Node(long value) {
            this.value = value;
        }

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
            calculateValueFromChildren();
        }

        protected void calculateValueFromChildren() {
            if (left != null) {
                value += left.value;
            }
            if (right != null) {
                value += right.value;
            }
        }
    }
}
