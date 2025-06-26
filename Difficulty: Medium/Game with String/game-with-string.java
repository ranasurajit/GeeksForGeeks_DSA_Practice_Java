class Solution {
    /**
     * Approach : Using Hashing + Max-Heap Approach
     * 
     * TC: O(N + K)
     * SC: O(26) + O(26) ~ O(1)
     */
    public int minValue(String s, int k) {
        int n = s.length();
        int[] freq = new int[26]; // SC: O(26)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[s.charAt(i) - 'a']++;
        }
        // Using a Max-Heap (PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p); // SC: O(26)
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }
        while (!pq.isEmpty() && k > 0) { // TC: O(K)
            int max = pq.poll();
            max = max - 1;
            k--;
            if (max > 0) {
                pq.offer(max);
            }
        }
        int result = 0;
        while (!pq.isEmpty()) { // TC: O(26)
            int val = pq.poll();
            result += (val * val);
        }
        return result;
    }
}
