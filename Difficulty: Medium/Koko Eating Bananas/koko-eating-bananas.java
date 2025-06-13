class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int kokoEat(int[] arr, int k) {
        int n = arr.length;
        // Koko's eating speed = 1 banana / hour
        int low = 1;
        // as arr.size() ≤ k ≤ 10 ^ 6, so, Koko's maximum eating speed = max(arr) / hour
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            high = Math.max(high, arr[i]);
        }
        // Applying Binary Search on Answers Approach
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            int timeNeeded = getMaximumTimeToFinishBananas(arr, n, mid); // TC: O(N)
            if (timeNeeded <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
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
    private int getMaximumTimeToFinishBananas(int[] arr, int n, int speed) {
        int time = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            time += (arr[i] % speed == 0) ? (arr[i] / speed) : (arr[i] / speed) + 1;
        }
        return time;
    }
}
