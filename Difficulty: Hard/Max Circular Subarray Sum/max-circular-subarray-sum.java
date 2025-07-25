class Solution {
    /**
     * Approach : Using Kadane's Algorithm Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int maxCircularSum(int arr[]) {
        int n = arr.length;
        // Using Kadane's Algorithm
        int maxLinearSum = Integer.MIN_VALUE;
        int minLinearSum = Integer.MAX_VALUE;
        int currentMaxLinearSum = 0;
        int currentMinLinearSum = 0;
        int total = 0;
        int countNegatives = 0;
        int maxNegatives = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            currentMaxLinearSum += arr[i];
            currentMinLinearSum += arr[i];
            total += arr[i];
            maxLinearSum = Math.max(maxLinearSum, currentMaxLinearSum);
            minLinearSum = Math.min(minLinearSum, currentMinLinearSum);
            if (currentMaxLinearSum < 0) {
                /**
                 * we reset currentMaxLinearSum to zero as we will not carry 
                 * negative sum to next sub-array sum
                 */
                currentMaxLinearSum = 0;
            }
            if (currentMinLinearSum > 0) {
                /**
                 * we reset currentMinLinearSum to zero as we will not carry 
                 * positive sum to next sub-array sum
                 */
                currentMinLinearSum = 0;
            }
            if (arr[i] < 0) {
                countNegatives++;
                maxNegatives = Math.max(maxNegatives, arr[i]);
            }
        }
        if (countNegatives == n) {
            // if all elements are negative we need to return the maximum of all negatives
            return maxNegatives;
        }
        /**
         * Maximum possible sum of circular array will be Maximum out of below:
         * 
         * 1. Maximum Linear Sum
         * 2. Total - Minimum Linear Sum
         */
        return Math.max(maxLinearSum, total - minLinearSum);
    }
}
