class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N) + O(N x log(Max(arr) - Min(arr))) ~ O(N x log(Max(arr) - Min(arr)))
     * SC: O(1)
     */
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        // bouquets needed = m * k;
        if (m * k > n) {
            // impossible to make m bouquets
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.min(low, arr[i]);
            high = Math.max(high, arr[i]);
        }
        while (low <= high) { // TC: O(log(Max(arr) - Min(arr)))
            int mid = low + (high - low) / 2;
            int countBouquets = countBouquetsMadeInDays(arr, n, k, mid); // TC: O(N)
            if (countBouquets < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    /**
     * Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private int countBouquetsMadeInDays(int[] arr, int n, int k, int mid) {
        int count = 0;
        int used = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] <= mid) {
                used++;
                if (used == k) {
                    count++;
                    used = 0;
                }
            } else {
                used = 0;
            }
        }
        return count;
    }
}
