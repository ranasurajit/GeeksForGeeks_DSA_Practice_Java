class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N) + O(N x log(P)) ~ O(N x log(P))
     * SC: O(1)
     * 
     * where P = Max(arr + k) - Min(arr)
     */
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.min(low, arr[i]);
            high = Math.max(high, arr[i] + k);
        }
        int maxHeight = 0;
        while (low <= high) { // TC: O(log(P))
            int mid = low + (high - low) / 2;
            if (calculateDaysToIncreaseHeight(arr, n, w, mid) > k) { // TC: O(N)
                high = mid - 1;
            } else {
                maxHeight = mid;
                low = mid + 1;
            }
        }
        return maxHeight;
    }

    /**
     * Using Difference Array Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private int calculateDaysToIncreaseHeight(int[] arr, int n, int w, int mid) {
        int[] diff = new int[n + 1];
        int added = 0;
        int ops = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            added += diff[i];
            int currentHeight = arr[i] + added;
            if (currentHeight < mid) {
                int increment = mid - currentHeight;
                ops += increment;
                added += increment; // apply now
                if (i + w < diff.length) {
                    diff[i + w] -= increment; // cancel later
                }
            }
        }
        return ops;
    }
}
