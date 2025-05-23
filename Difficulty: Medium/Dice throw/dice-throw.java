class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N x T + N)
     * SC: O(N x T + N)
     */
    static int noOfWays(int m, int n, int x) {
        int[] sum = { 0 };
        int[][] memo = new int[n + 1][x + 1]; // SC: O(N x T)
        for (int[] mem : memo) { // TC: O(N)
            Arrays.fill(mem, -1);
        }
        return solveMemoization(m, n, x, sum, memo);
    }

    /**
     * Using Memoization Approach
     * 
     * TC: O(N x T)
     * SC: O(N)
     */
    private static int solveMemoization(int m, int n, int x, int[] sum, int[][] memo) {
        // Base Case
        if (n == 0) {
            return sum[0] == x ? 1 : 0;
        }
        // Memoization Check
        if (memo[n][sum[0]] != -1) {
            return memo[n][sum[0]];
        }
        // Recursion Calls
        int ways = 0;
        for (int i = 1; i <= m; i++) {
            // 1 to m values possible for a throw
            if (sum[0] + i <= x) {
                ways += solveMemoization(m, n - 1, x, new int[] { sum[0] + i }, memo);
            }
        }
        return memo[n][sum[0]] = ways;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(M ^ N)
     * SC: O(N)
     */
    static int noOfWaysRecursion(int m, int n, int x) {
        int[] sum = { 0 };
        return solveRecursion(m, n, x, sum);
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(M ^ N)
     * SC: O(N)
     */
    private static int solveRecursion(int m, int n, int x, int[] sum) {
        // Base Case
        if (n == 0) {
            return sum[0] == x ? 1 : 0;
        }
        // Recursion Calls
        int ways = 0;
        for (int i = 1; i <= m; i++) {
            // 1 to m values possible for a throw
            if (sum[0] + i <= x) {
                ways += solveRecursion(m, n - 1, x, new int[] { sum[0] + i });
            }
        }
        return ways;
    }
};
