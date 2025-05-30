class Solution {
    /**
     * Approach : Using Max-Heap (PriorityQueue) Approach
     * 
     * TC: O(N x N x log(N))
     * SC: O(K)
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // to get the kth smallest we will take Max-Heap (PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p); // SC: O(K)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (pq.size() < k) {
                    pq.offer(matrix[i][j]); // TC: O(log(N))
                } else {
                    if (matrix[i][j] < pq.peek()) {
                        pq.poll();
                        pq.offer(matrix[i][j]); // TC: O(log(N))
                    }
                }
            }
        }
        return pq.peek();
    }
}
