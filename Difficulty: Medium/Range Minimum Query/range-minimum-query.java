/* The functions which
builds the segment tree */
class GfG {
    static int st[];

    public static int[] constructST(int arr[], int n) {
        int[] segTree = new int[4 * n];
        buildSegmentTree(arr, segTree, 0, 0, n - 1);
        return segTree;
    }
    
    private static void buildSegmentTree(int[] arr, int[] segTree, int segIdx, 
        int left, int right) {
        // Base Case
        if (left == right) {
            segTree[segIdx] = arr[left];
            return;
        }
        // Recursion Leap of Faith
        int mid = left + (right - left) / 2;
        // left sub-tree
        buildSegmentTree(arr, segTree, 2 * segIdx + 1, left, mid);
        // right sub-tree
        buildSegmentTree(arr, segTree, 2 * segIdx + 2, mid + 1, right);
        segTree[segIdx] = Math.min(segTree[2 * segIdx + 1], segTree[2 * segIdx + 2]);
    }

    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r) {
        return getMinRangeQuery(l, r, st, 0, 0, n - 1);
    }
    
    private static int getMinRangeQuery(int start, int end, int[] st, int segIdx,
        int left, int right) {
        // Base Case
        if (left > end || right < start) {
            // out of bound
            return Integer.MAX_VALUE;
        }
        if (left >= start && right <= end) {
            // full overlap
            return st[segIdx];
        }
        // Recursion
        // partial overlap
        int mid = left + (right - left) / 2;
        return Math.min(
            getMinRangeQuery(start, end, st, 2 * segIdx + 1, left, mid),
            getMinRangeQuery(start, end, st, 2 * segIdx + 2, mid + 1, right)
        );
    }
}
