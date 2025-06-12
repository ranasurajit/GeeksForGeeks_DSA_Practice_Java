class Solution {
    /**
     * Approach I : Using Min-Heap (PriorityQueue) Approach
     * 
     * TC: O(N x log(K) + K) ~ O(N x log(K))
     * SC: O(K)
     */
    int[] printKClosest(int[] arr, int k, int x) {
        int n = arr.length;
        int[] result = new int[k];
        // we will be storing { arr[i], Abs(arr[i] - x) } in Min-Heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> {
            if (p[1] == q[1]) {
                return (q[0] - p[0]);
            }
            return (p[1] - q[1]);
        }); // SC: O(K)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] != x) {
                pq.offer(new int[] { arr[i], Math.abs(arr[i] - x) }); // TC: O(log(K))
            }
        }
        int index = 0;
        while (!pq.isEmpty() && k > 0) { // TC: O(K)
            result[index++] = pq.poll()[0];
            k--;
        }
        return result;
    }
}
