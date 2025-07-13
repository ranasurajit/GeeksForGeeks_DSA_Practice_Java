class Solution {
    /**
     * Approach : Using Tabulation Optimized DP
     * 
     * TC: O(N x N) + O(N) ~ O(N x N)
     * SC: O(N) + O(N) ~ O(N)
     */
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // SC: O(N)
        int maxLISLength = 1;
        int sumArr = 0;
        // track sum of elements in any LIS
        int[] sumDP = new int[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            sumArr += arr[i];
            dp[i] = 1;
            sumDP[i] = arr[i];
            for (int prev = 0; prev < i; prev++) { // TC: O(N)
                if (arr[i] > arr[prev] && dp[i] <= dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    sumDP[i] = sumDP[prev] + arr[i];
                }
                if (maxLISLength < dp[i]) {
                    maxLISLength = dp[i];
                }
            }
        }
        // comparing the sums used in LIS to get minimum sum LIS
        int minSumLIS = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (dp[i] == maxLISLength) {
                minSumLIS = Math.min(minSumLIS, sumDP[i]);
            }
        }
        return sumArr - minSumLIS;
    }
}
