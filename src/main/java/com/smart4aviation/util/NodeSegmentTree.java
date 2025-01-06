package com.smart4aviation.util;

/**
 * <p>Segment Tree implementation as-is, where each Node has reference to the left and right child.</p>
 * <p>This implementation of Segment Tree does not hold array internally. Examples which use data[i] are for the explanation purpose.</p>
 */
public class NodeSegmentTree {
    private Node root;
    private final int range; // length of array from which NodeSegmentTree was constructed

    /**
     * <p>Constructs Segment Tree from the values provided in array.</p>
     * <p>Values from the given array are copied. It's not used internally.</p>
     * @param data array which elements are used for construction.
     * @throws IllegalArgumentException if given array is null or have 0 length.
     */
    public NodeSegmentTree(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException();
        }
        range = data.length;
        root = build(data, 0, range - 1);
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
     * <p>Time complexity of this operation is O(log n).</p>
     * @param leftBoundary of the segment. Minimum value is 0.
     * @param rightBoundary of the segment. Maximum value is <code>length - 1</code> of initial array size from which Segment Tree was constructed.
     * @return sum of the numbers in the specified segment.
     * @throws IllegalArgumentException if <code>leftBoundary</code> is bigger than <code>rightBoundary</code>.
     * @throws IndexOutOfBoundsException if <code>leftBoundary</code> is less than zero or <code>rightBoundary</code> is greater or equal to initial array size from which Segment Tree was constructed.
     */
    public long sum(int leftBoundary, int rightBoundary) {
        if (leftBoundary > rightBoundary) {
            throw new IllegalArgumentException("Specified left boundary is bigger than right boundary");
        }
        if (leftBoundary < 0 || rightBoundary >= range) {
            throw new IndexOutOfBoundsException("Boundaries out of provided data length");
        }
        return sum(root, 0, range - 1, leftBoundary, rightBoundary);
    }

    /**
     * @see NodeSegmentTree#sum(int, int)
     * @param node which represents current segment.
     * @param cl current segment left boundary.
     * @param cr current segment right boundary.
     * @param l left boundary of a query.
     * @param r right boundary of a query.
     * @return sum of the numbers in the specified segment.
     */
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

    /**
     * <p>Updates number in the data array to the given one: data[position] = newData.</p>
     * @param position index of the number to update.
     * @param newData new value for the number on given index.
     * @throws IndexOutOfBoundsException if <code>position</code> is negative or is greater or equal to initial array size from which Segment Tree was constructed.
     */
    public void update(int position, int newData) {
        if (position < 0 || position >= range) {
            throw new IndexOutOfBoundsException("Position out of boundaries.");
        }
        root = update(root, 0, range - 1, position, newData);
    }

    /**
     * @see NodeSegmentTree#update(int, int)
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

    public void print() {
        System.out.println("============");
        System.out.println("SegmentTree: ");
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
