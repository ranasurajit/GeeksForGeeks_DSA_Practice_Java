class Solution {
    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(N x N) ~ O(N ^ 2)
     * SC: O(N)
     */
    public int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n + 1]; // SC: O(N)
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // empty string
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            for (int j = 0; j < i; j++) { // TC: O(N)
                String sub = s.substring(j, i);
                if (isPowerOfFive(sub) && dp[j] != Integer.MAX_VALUE) { // TC: O(L)
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x N) ~ O(N ^ 2)
     * SC: O(N) + O(N) ~ O(N)
     */
    public int cutsMemoization(String s) {
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int minCuts = solveMemoization(0, n, s, memo); // TC: O(N x N), SC: O(N)
        return minCuts == Integer.MAX_VALUE ? -1 : minCuts;
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N x N)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, String s, int[] memo) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        if (s.charAt(idx) == '0') {
            // No substring should have leading zeros
            return Integer.MAX_VALUE;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int minCuts = Integer.MAX_VALUE;
        // Recursion Calls
        for (int i = idx; i < n; i++) { // TC: O(N)
            String sub = s.substring(idx, i + 1);
            if (isPowerOfFive(sub)) { // TC: O(L)
                int cuts = solveMemoization(i + 1, n, s, memo);
                if (cuts != Integer.MAX_VALUE) {
                    // as we got 1 split/cut so we added 1
                    minCuts = Math.min(minCuts, cuts + 1);
                }
            }
        }
        return memo[idx] = minCuts;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    public int cutsRecursion(String s) {
        int n = s.length();
        int minCuts = solveRecursion(0, n, s); // TC: O(N x 2 ^ N), SC: O(N)
        return minCuts == Integer.MAX_VALUE ? -1 : minCuts;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, String s) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        if (s.charAt(idx) == '0') {
            // No substring should have leading zeros
            return Integer.MAX_VALUE;
        }
        int minCuts = Integer.MAX_VALUE;
        // Recursion Calls
        for (int i = idx; i < n; i++) { // TC: O(N)
            String sub = s.substring(idx, i + 1);
            if (isPowerOfFive(sub)) { // TC: O(L)
                int cuts = solveRecursion(i + 1, n, s);
                if (cuts != Integer.MAX_VALUE) {
                    // as we got 1 split/cut so we added 1
                    minCuts = Math.min(minCuts, cuts + 1);
                }
            }
        }
        return minCuts;
    }

    /**
     * Using Simulation + Binary Conversion Approach
     * 
     * TC: O(L) where L = length of String sub
     * SC: O(1)
     */
    private boolean isPowerOfFive(String sub) {
        if (sub.charAt(0) == '0') {
            // No substring should have leading zeros
            return false;
        }
        long num = Long.parseLong(sub, 2); // converting binary string to decimal
        while (num > 0 && num % 5 == 0) {
            num = num / 5;
        }
        return num == 1L;
    }
}
