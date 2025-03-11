//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach II : Using Tabulation Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N)
     * SC: O(2 x N)
     */
    int countWaysMemoization(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solveMemoization(n, memo);
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveMemoization(int n, int[] memo) {
        // Base Case
        if (n <= 1) {
            return 1; 
        }
        // Memoization Check
        if (memo[n] != -1) {
            return memo[n];
        }
        // Recursion Calls
        return solveMemoization(n - 1, memo) + solveMemoization(n - 2, memo);
    }
    
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    int countWaysRecursion(int n) {
        return solveRecursion(n);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n) {
        if (n <= 1) {
            return 1; 
        }
        // Recursion Calls
        return solveRecursion(n - 1) + solveRecursion(n - 2);
    }
}
