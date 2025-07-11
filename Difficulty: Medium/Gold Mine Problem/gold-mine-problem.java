class Solution {
    private int m;
    private int n;

    /**
     * Approach IV : Using Space Optimization (Optimized DP) Approach
     * 
     * TC: O(M) + O(N x M) + O(M) ~ O(N x M)
     * SC: O(M) + O(M) ~ O(M)
     *
     * Accepted (1120 / 1120 testcases passed)
     */
    public int maxGold(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int maxValue = 0;
        // Initialization
        int[] current = new int[m]; // SC: O(M)
        int[] next = new int[m]; // SC: O(M)
        for (int i = 0; i < m; i++) { // TC: O(M)
            next[i] = mat[i][n - 1];
        }
        // Iterative Calls
        for (int j = n - 2; j >= 0; j--) { // TC: O(N)
            for (int i = m - 1; i >= 0; i--) { // TC: O(M)
                int sameRowCol = next[i];
                int upRowCol = i > 0 ? next[i - 1] : 0;
                int downRowCol = i < m - 1 ? next[i + 1] : 0;
                current[i] = mat[i][j] + Math.max(sameRowCol, Math.max(upRowCol, downRowCol));
            }
            next = current.clone();
        }
        for (int val : next) { // TC: O(M)
            maxValue = Math.max(maxValue, val);
        }
        return maxValue;
    }

    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(M) + O(N x M) + O(M) ~ O(M x N)
     * SC: O(M x N)
     *
     * Accepted (1120 / 1120 testcases passed)
     */
    public int maxGoldTabulation(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int maxValue = 0;
        // Initialization
        int[][] dp = new int[m][n]; // SC: O(M x N)
        for (int i = 0; i < m; i++) { // TC: O(M)
            dp[i][n - 1] = mat[i][n - 1];
        }
        // Iterative Calls
        for (int j = n - 2; j >= 0; j--) { // TC: O(N)
            for (int i = m - 1; i >= 0; i--) { // TC: O(M)
                int sameRowCol = dp[i][j + 1];
                int upRowCol = i > 0 ? dp[i - 1][j + 1] : 0;
                int downRowCol = i < m - 1 ? dp[i + 1][j + 1] : 0;
                dp[i][j] = mat[i][j] + Math.max(sameRowCol, Math.max(upRowCol, downRowCol));
            }
        }
        for (int start = 0; start < m; start++) { // TC: O(M)
            maxValue = Math.max(maxValue, dp[start][0]);
        }
        return maxValue;
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(M x N) + O(M x N) ~ O(M x N)
     * SC: O(M x N) + O(N)
     *
     * Accepted (1120 / 1120 testcases passed)
     */
    public int maxGoldMemoization(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int maxValue = 0;
        int[][] memo = new int[m + 1][n + 1]; // SC: O(M x N)
        for (int[] mem : memo) { // TC: O(M)
            Arrays.fill(mem, -1); // TC: O(N)
        }
        for (int i = 0; i < m; i++) { // TC: O(M)
            maxValue = Math.max(maxValue, 
                solveMemoization(i, 0, mat, memo)); // TC: O(M x N), SC: O(N)
        }
        return maxValue;
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(M x N)
     * SC: O(N)
     */
    private int solveMemoization(int row, int col, int[][] mat, int[][] memo) {
        // Base Case
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        // Memoization
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        // Recursion Calls
        int sameRowCol = solveMemoization(row, col + 1, mat, memo);
        int upRowCol = solveMemoization(row - 1, col + 1, mat, memo);
        int downRowCol = solveMemoization(row + 1, col + 1, mat, memo);
        return memo[row][col] = mat[row][col] + 
            Math.max(sameRowCol, Math.max(upRowCol, downRowCol));
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(M x 3 ^ N)
     * SC: O(N)
     * 
     * Time Limit Exceeded (10 / 1120 testcases passed)
     */
    public int maxGoldRecursion(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int maxValue = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            maxValue = Math.max(maxValue, solveRecursion(i, 0, mat)); // TC: O(3 ^ N), SC: O(N)
        }
        return maxValue;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(3 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int row, int col, int[][] mat) {
        // Base Case
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        // Recursion Calls
        int sameRowCol = solveRecursion(row, col + 1, mat);
        int upRowCol = solveRecursion(row - 1, col + 1, mat);
        int downRowCol = solveRecursion(row + 1, col + 1, mat);
        return mat[row][col] + Math.max(sameRowCol, Math.max(upRowCol, downRowCol));
    }
}
