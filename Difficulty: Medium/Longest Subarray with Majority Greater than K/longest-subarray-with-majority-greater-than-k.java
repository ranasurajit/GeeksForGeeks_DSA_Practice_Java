class Solution {
    /**
     * Approach II : Using Array Transformation + Hashing Approach
     * 
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     * 
     * Accepted (1115/1115 testcases passed)
     */
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        /**
         * Transform all elements > k as 1 and all elements <= k as -1
         * 
         * so the problem is reduced to finding the longest sub-array with sum > 0
         */
        for (int i = 0; i < n; i++) {     // TC: O(N)
            arr[i] = arr[i] > k ? 1 : -1;
        }
        /**
         * We will be using a HashMap to store the prefixSums if not present and check 
         * if we have seen the diff = prefixSum - 1 in the HashMap
         */
        int maxLength = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            prefixSum += arr[i];
            if (prefixSum > 0) {
                maxLength = i + 1;
            } else {
                if (!map.containsKey(prefixSum)) {
                    map.put(prefixSum, i);
                }
                int diff = prefixSum - 1;
                if (map.containsKey(diff)) {
                    maxLength = Math.max(maxLength, i - map.get(diff));
                }
            }
        }
        return maxLength;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N x N)
     * SC: O(1)
     * 
     * Time Limit Exceeded (1110/1115 testcases passed)
     */
    public int longestSubarrayBruteForce(int[] arr, int k) {
        int n = arr.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            int countGTK = 0;
            int countLTEK = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                if (arr[j] > k) {
                    countGTK++;
                } else {
                    countLTEK++;
                }
                if (countGTK > countLTEK) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
}
