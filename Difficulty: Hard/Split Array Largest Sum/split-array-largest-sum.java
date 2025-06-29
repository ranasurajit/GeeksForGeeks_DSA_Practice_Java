class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N) + O(N x log(R)) ~ O(N x log(R)
     * SC: O(1)
     * 
     * where R = Range (Max(arr), Sum(arr))
     */
    public int splitArray(int[] arr, int k) {
        int n = arr.length;
        long low = 0L;
        long high = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.max(low, (long) arr[i]);
            high += (long) arr[i];
        }
        if (k == 1) {
            return (int) high;
        }
        while (low <= high) { // TC: O(log(R))
            long mid = low + (high - low) / 2;
            if (countSubArraysWithSum(arr, n, mid) <= (long) k) { // TC: O(N)
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    /**
     * Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private long countSubArraysWithSum(int[] arr, int n, long mid) {
        long sum = 0L;
        long count = 1L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (sum + (long) arr[i] <= mid) {
                sum += (long) arr[i];
            } else {
                count++;
                sum = (long) arr[i];
            }
        }
        return count;
    }
};
