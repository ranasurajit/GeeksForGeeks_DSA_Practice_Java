
class Solution {
    /**
     * Approach : Using Hashing + Array Pre-processing (Prefix-Sum) Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int longestCommonSum(int[] a1, int[] a2) {
        /**
         * we need longest span from arrays 'a1' and 'a2' so that,
         * a1[i] + a1[i+1] + .... + a1[j] =  a2[i] + a2[i+1] + ... + a2[j]
         * which implies:
         * 
         * (a1[i] - a2[i]) + (a1[i+1] - a2[i+1]) + .... + (a1[j] - a2[j]) = 0
         * such that j >= i
         * 
         * so we can pre-compute a1[i] = a1[i] - a2[i] in place
         */
        int n = a1.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            a1[i] = a1[i] - a2[i];
        }
        /**
         * now the problem is reduced to finding longest sub-array with sum = 0;
         */
        int maxLength = 0;
        // we will be storing { sum[i], i } in HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        map.put(0, -1);
        int i = 0;
        int prefixSum = 0;
        while (i < n) { // TC: O(N)
            prefixSum += a1[i];
            int diff = prefixSum;
            if (map.containsKey(diff)) {
                maxLength = Math.max(maxLength, i - map.get(diff));
            } else {
                map.put(prefixSum, i);
            }
            i++;
        }
        return maxLength;
    }
}
