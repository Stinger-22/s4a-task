package com.smart4aviation.util;

/**
 * <p>Generic interface for Segment Tree data structure. It stores information about array intervals as tree. This allows answering range queries over an array efficiently and quick modification of the array.</p>
 * <p>This interface provides two methods for interaction with Segment Tree.</p>
 * <p>Segment Tree indexing is zero-based.</p>
 */
public interface SegmentTree {

    /**
     * <p>Performs query on the given segment and returns it's result.</p>
     * <p>Time complexity of this operation is O(log n).</p>
     * @param leftBoundary of the segment. Minimum value is 0.
     * @param rightBoundary of the segment. Maximum value is <code>length - 1</code> of initial array size from which Segment Tree was constructed.
     * @return result of the query.
     * @throws IllegalArgumentException if <code>leftBoundary</code> is bigger than <code>rightBoundary</code>.
     * @throws IndexOutOfBoundsException if <code>leftBoundary</code> is less than zero or <code>rightBoundary</code> is greater or equal to initial array size from which Segment Tree was constructed.
     */
    long query(int leftBoundary, int rightBoundary);

    /**
     * <p>Updates number in the data array to the given one (data[position] = newData) and updates related nodes. Updated nodes are new objects.</p>
     * <p>Time complexity of this operation is O(log n).</p>
     * @param position index of the number to update.
     * @param newData new value for the number on given index.
     * @throws IndexOutOfBoundsException if <code>position</code> is negative or is greater or equal to initial array size from which Segment Tree was constructed.
     */
    void update(int position, int newData);
}
