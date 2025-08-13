class Solution {
    /**
     * Approach : Using Sorting / PriorityQueue (Max-Heap) Approach
     * 
     * TC: O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(N)
     */
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int m = n / 2; // m = minimum troops to be multiple of k
        if ((n & 1) != 0) {
            m = m + 1;
        }
        PriorityQueue<Integer> pq = 
            new PriorityQueue<Integer>((p, q) -> q - p); // SC: O(N)
        int countOdds = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] % k != 0) {
                countOdds++;
                pq.offer(arr[i] % k); // TC: O(log(N))
            }
        }
        int remaining = m - (n - countOdds);
        int added = 0;
        while (!pq.isEmpty() && remaining > 0) {  // TC: O(N)
            int current = pq.poll();
            added += (k - current);
            remaining--;
        }
        return added;
    }
}
