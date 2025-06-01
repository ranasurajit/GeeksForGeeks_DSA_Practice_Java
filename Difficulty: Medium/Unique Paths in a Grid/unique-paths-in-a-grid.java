class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N x M)
     * SC: O(N x M + (M + N))
     * 
     * Accepted : Test Cases Passed: (1120 /1120)
     */
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m]; // SC: O(N x M)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(n - 1, m - 1, grid, memo);
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N x M)
     * SC: O(N + M)
     */
    private int solveMemoization(int n, int m, int[][] grid, int[][] memo) {
        // Base Case
        if (n >= 0 && m >= 0 && grid[n][m] == 1) {
            return 0;
        }
        if (n == 0 && m == 0) {
            return 1;
        }
        if (n < 0 || m < 0) {
            return 0;
        }
        // Memoization Check
        if (memo[n][m] != -1) {
            return memo[n][m];
        }
        // Recursion Calls
        /**
         * consider opposite movement from cell (n - 1, m - 1) to (0, 0)
         * we can either move left or right
         */
        int leftWays = solveMemoization(n, m - 1, grid, memo);
        int rightWays = solveMemoization(n - 1, m, grid, memo);
        return memo[n][m] = leftWays + rightWays;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ (N x M))
     * SC: O(N + M)
     * 
     * Time limit exceeded : Test Cases Passed: (1010 /1120)
     */
    public int uniquePathsRecursion(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return solveRecursion(n - 1, m - 1, grid);
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ (N x M))
     * SC: O(N + M)
     */
    private int solveRecursion(int n, int m, int[][] grid) {
        // Base Case
        if (n >= 0 && m >= 0 && grid[n][m] == 1) {
            return 0;
        }
        if (n == 0 && m == 0) {
            return 1;
        }
        if (n < 0 || m < 0) {
            return 0;
        }
        // Recursion Calls
        /**
         * consider opposite movement from cell (n - 1, m - 1) to (0, 0)
         * we can either move left or right
         */
        int leftWays = solveRecursion(n, m - 1, grid);
        int rightWays = solveRecursion(n - 1, m, grid);
        return leftWays + rightWays;
    }
};
