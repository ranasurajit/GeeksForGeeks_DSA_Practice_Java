// User function Template for Java

class Solution {
    /**
     * Approach II : Using Sorting Approach
     *
     * TC: O(N x log(N))
     * SC: O(1)
     */
    public static int kthSmallest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        return arr[k - 1];
    }
    
    /**
     * Approach I : Using PriorityQueue (Max-Heap) Approach
     *
     * TC: O(N x log(N))
     * SC: O(K)
     */
    public static int kthSmallestUsingHeaps(int[] arr, int k) {
        int n = arr.length;
        // we will insert elements to Max-Heap (PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p); // SC: O(K)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (pq.size() < k) {
                pq.offer(arr[i]);     // TC: O(log(N))
            } else {
                if (!pq.isEmpty() && arr[i] < pq.peek()) {
                    pq.poll();
                    pq.offer(arr[i]); // TC: O(log(N))
                }
            }
        }
        return pq.peek();
    }
}
