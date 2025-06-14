class Solution {
    /**
     * Approach II : Using Binary Search Approach
     * 
     * TC: O(N + N x log(Max(arr))) ~ O(N x log(Max(arr)))
     * SC: O(1)
     * 
     * Accepted - Test Cases Passed: 1120 /1120
     */
    int smallestDivisor(int[] arr, int k) {
        int n = arr.length;
        int low = 1;
        int high = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            high = Math.max(high, arr[i]);
        }
        while (low <= high) { // TC: O(log(Max(arr)))
            int mid = low + (high - low) / 2;
            int answer = getCalculatedValue(arr, n, mid); // TC: O(N)
            if (answer <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Approach I : Using Linear Search Approach
     * 
     * TC: O(N + N x Max(arr)) ~ O(N x Max(arr))
     * SC: O(1)
     * 
     * Time limit exceeded - Test Cases Passed: 1010 /1120
     */
    int smallestDivisorUsingLinearSearch(int[] arr, int k) {
        int n = arr.length;
        int low = 1;
        int high = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            high = Math.max(high, arr[i]);
        }
        int minDiv = high;
        for (int div = high; div >= low; div--) { // TC: O(Max(arr))
            int answer = getCalculatedValue(arr, n, div); // TC: O(N)
            if (answer <= k) {
                minDiv = Math.min(minDiv, div);
            }
        }
        return minDiv;
    }
    
    /**
     * Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private int getCalculatedValue(int[] arr, int n, int div) {
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += (arr[i] % div == 0) ? (arr[i] / div) : (arr[i] / div) + 1;
        }
        return sum;
    }
}
