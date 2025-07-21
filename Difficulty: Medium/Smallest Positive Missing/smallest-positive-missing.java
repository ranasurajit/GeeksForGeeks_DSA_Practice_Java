class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N) + O(Max(arr))
     * SC: O(N)
     */
    public int missingNumber(int[] arr) {
        int n = arr.length;
        Set<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] > 0) {
                hs.add(arr[i]);
            }
            max = Math.max(max, arr[i]);
        }
        /**
         * Note: If all positive numbers are present from 1 to Max(arr),
         * then missing would be Max(arr) + 1
         */
        for (int i = 1; i <= max + 1; i++) { // TC: O(Max(arr))
            if (!hs.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
