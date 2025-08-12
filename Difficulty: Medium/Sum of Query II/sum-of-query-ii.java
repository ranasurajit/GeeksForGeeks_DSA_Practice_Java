// User function Template for Java

class Solution {
    /**
     * Approach : Using Segment Tree Approach
     * 
     * TC: O(N) + O(Q x log(N)) ~ O(N + Q x log(N))
     * SC: O(N) + O(log(N))
     */
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        long[] segTree = new long[4 * n]; // SC: O(4 x N)
        buildSegmentTree(segTree, 0, n - 1, arr, 0); // TC: O(N), SC: O(log(N))
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < q; i++) { // TC: O(Q)
            // 0-based indexing
            int start = queries[2 * i] - 1;
            int end = queries[2 * i + 1] - 1;
            result.add((int) getRangeQuerySum(segTree,
                0, 0, n - 1, start, end)); // TC: O(log(N)), SC: O(log(N))
        }
        return result;
    }
    
    /**
     * Using Segment Tree Approach
     * 
     * TC: O(2 x N) as each node is visited exactly twice ~ O(N)
     * SC: O(log(N))
     */
    private void buildSegmentTree(long[] segTree, int left, int right, int[] arr, int segIdx) {
        // Base Case
        if (left == right) {
            segTree[segIdx] = arr[left];
            return;
        }
        // Recursion Leap of Faith
        int mid = left + (right - left) / 2;
        // left sub-tree
        buildSegmentTree(segTree, left, mid, arr, segIdx * 2 + 1);
        // right sub-tree
        buildSegmentTree(segTree, mid + 1, right, arr, segIdx * 2 + 2);
        segTree[segIdx] = segTree[segIdx * 2 + 1] + segTree[segIdx * 2 + 2];
    }
    
    /**
     * Using Segment Tree Approach
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private long getRangeQuerySum(long[] segTree, int segIdx,
        int left, int right, int start, int end) {
        // Base Case
        if (left > end || right < start) {
            // out of bound
            return 0L;
        }
        if (left >= start && right <= end) {
            // full overlap
            return segTree[segIdx];
        }
        // Recursion Calls
        // partial overlap
        int mid = left + (right - left) / 2;
        return getRangeQuerySum(segTree, 2 * segIdx + 1, left, mid, start, end) +
            getRangeQuerySum(segTree, 2 * segIdx + 2, mid + 1, right, start, end);
    }
}
