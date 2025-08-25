class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N x log(N)) + O(N x log(Max(arr) + k - Median(arr)))) ~  O(N x log(N))
     * SC: O(1)
     */
    public int maximizeMedian(int[] arr, int k) {
        int n = arr.length;
        /**
         * We need to sort Array 'arr'
         * 
         * To maximize the median we need to focus on the mid to last element
         * where we can perform the increment operation so we need to see if
         * arr is odd or even length 
         */
        Arrays.sort(arr); // TC: O(N x log(N))
        // if k = 0, we do not perform any operation but return the actual median of array 'arr'
        if (k == 0) {
            if ((n & 1) == 0) {
                return (arr[n / 2 - 1] + arr[n / 2]) / 2;
            } else {
                return arr[n / 2];
            }
        }
        int medianIdx = n / 2;
        int low = arr[medianIdx];
        int high = arr[n - 1] + k;
        // Applying Binary Search
        while (low <= high) { // TC: O(log(Max(arr) + k - Median(arr))))
            int mid = low + (high - low) / 2;
            int operationsNeeded = 
                countOperationsToMakeMedianMid(arr, n, medianIdx, mid); // TC: O(N)
            if (operationsNeeded <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    
    /**
     * Using Simulation Approach
     * 
     * TC: O(N / 2)
     * SC: O(1)
     */
    private int countOperationsToMakeMedianMid(int[] arr, int n, int medIdx, int mid) {
        int count = 0;
        if ((n & 1) == 0) {
            // if n is even we need to raise arr[medIdx - 1] as well
            medIdx = medIdx - 1;
        }
        for (int i = medIdx; i < n; i++) { // TC: O(N / 2)
            if (arr[i] < mid) {
                count += mid - arr[i];
            }
        }
        return count;
    }
}
