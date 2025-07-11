class Solution {
    /**
     * Approach IV : Using Space Optimization (Optimized DP) Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(2) + O(2) ~ O(1)
     * 
     * Accepted (30 / 30 testcases passed)
     */
    public int countConsec(int n) {
        /**
         * total combinations we can make using 0's and 1's of length n String is 2 ^ N
         * so, we need to compute number of Strings having no consective 1's
         */
        // Initialization
        int[] prev = new int[2]; // SC: O(2)
        prev[0] = 1;
        prev[1] = 1;
        // Iterative Calls
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            int[] current = new int[2]; // SC: O(2)
            for (int j = 0; j < 2; j++) { // TC: O(2)
                if (j == 0) {
                    current[j] = prev[0] + prev[1];
                } else {
                    current[j] = prev[0];
                }
            }
            prev = current;
        }
        return (int) Math.pow(2, n) - prev[0];
    }

    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     * 
     * Accepted (30 / 30 testcases passed)
     */
    public int countConsecTabulation(int n) {
        /**
         * total combinations we can make using 0's and 1's of length n String is 2 ^ N
         * so, we need to compute number of Strings having no consective 1's
         */
        // Initialization
        int[][] dp = new int[n + 1][2]; // SC: O(N x 2)
        dp[0][0] = 1;
        dp[0][1] = 1;
        // Iterative Calls
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            for (int j = 0; j < 2; j++) { // TC: O(2)
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + dp[i - 1][1];
                } else {
                    dp[i][j] = dp[i - 1][0];
                }
            }
        }
        return (int) Math.pow(2, n) - dp[n][0];
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(2 x N) + O(2 x N) ~ O(N)
     * SC: O(2 x N) + O(N) ~ O(N)
     * 
     * Accepted (30 / 30 testcases passed)
     */
    public int countConsecMemoization(int n) {
        /**
         * total combinations we can make using 0's and 1's of length n String is 2 ^ N
         * so, we need to compute number of Strings having no consective 1's
         */
        int[][] memo = new int[n + 1][2]; // SC: O(N x 2)
        for (int[] mem : memo) {  // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(2)
        }
        int result = solveMemoization(n, 0, memo); // TC: O(N x 2), SC: O(N)
        return (int) Math.pow(2, n) - result;
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N x 2)
     * SC: O(N)
     */
    private int solveMemoization(int n, int lastBit, int[][] memo) {
        // Base Case
        if (n == 0) {
            return 1;
        }
        // Memoization Check
        if (memo[n][lastBit] != -1) {
            return memo[n][lastBit];
        }
        // Recursion Calls
        if (lastBit == 0) {
            // we can place either 0 or 1 - does not matter as it will not place two 1's i.e. 11
            return memo[n][lastBit] = 
                solveMemoization(n - 1, 0, memo) + solveMemoization(n - 1, 1, memo);
        } else {
            // we can place only zero as if we choose 1 then we may end up getting 11
            return memo[n][lastBit] = solveMemoization(n - 1, 0, memo);
        }
    }
    
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     * 
     * Accepted (30 / 30 testcases passed)
     */
    public int countConsecRecursion(int n) {
        /**
         * total combinations we can make using 0's and 1's of length n String is 2 ^ N
         * so, we need to compute number of Strings having no consective 1's
         */
        int result = solveRecursion(n, 0); // TC: O(2 ^ N), SC: O(N)
        return (int) Math.pow(2, n) - result;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n, int lastBit) {
        // Base Case
        if (n == 0) {
            return 1;
        }
        // Recursion Calls
        if (lastBit == 0) {
            // we can place either 0 or 1 - does not matter as it will not place two 1's i.e. 11
            return solveRecursion(n - 1, 0) + solveRecursion(n - 1, 1);
        } else {
            // we can place only zero as if we choose 1 then we may end up getting 11
            return solveRecursion(n - 1, 0);
        }
    }
}
