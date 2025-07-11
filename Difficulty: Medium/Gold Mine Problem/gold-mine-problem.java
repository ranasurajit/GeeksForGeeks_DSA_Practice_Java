class Solution {
    private int m;
    private int n;

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(M x N) + O(M x M x N) ~ O(M x M x N)
     * SC: O(M x N) + O(N)
     *
     * Accepted (1120 / 1120 testcases passed)
     */
    public int maxGold(int[][] mat) {
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
