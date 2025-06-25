// User function Template for Java
class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N + N)
     *
     * Accepted (1115 / 1115 testcases passed)
     */
    int minCost(int[] height) {
        int n = height.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solveMemoization(n - 1, height, memo);
    }
    
    /**
     * Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveMemoization(int n, int[] height, int[] memo) {
        // Base Case
        if (n == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[n] != -1) {
            return memo[n];
        }
        // Recursion Calls
        int cost1Step = Math.abs(height[n] - height[n - 1]) + 
            solveMemoization(n - 1, height, memo);
        int cost2Step = Integer.MAX_VALUE;
        if (n > 1) {
            cost2Step = Math.abs(height[n] - height[n - 2]) + 
            solveMemoization(n - 2, height, memo);
        }
        return memo[n] = Math.min(cost1Step, cost2Step);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (10 / 1115 testcases passed)
     */
    int minCostRecursion(int[] height) {
        int n = height.length;
        return solveRecursion(n - 1, height);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n, int[] height) {
        // Base Case
        if (n == 0) {
            return 0;
        }
        // Recursion Calls
        int cost1Step = Math.abs(height[n] - height[n - 1]) + 
            solveRecursion(n - 1, height);
        int cost2Step = Integer.MAX_VALUE;
        if (n > 1) {
            cost2Step = Math.abs(height[n] - height[n - 2]) + 
            solveRecursion(n - 2, height);
        }
        return Math.min(cost1Step, cost2Step);
    }
}
