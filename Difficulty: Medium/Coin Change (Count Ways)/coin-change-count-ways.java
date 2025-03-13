//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N x S)
     * SC: O(N x S + N)
     * 
     * where S = sum
     */
    public int count(int coins[], int sum) {
        int n = coins.length;
        int[][] memo = new int[n + 1][sum + 1]; // SC: O(N x S)
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        return solveMemoization(n, coins, sum, memo);
    }
    
    /**
     * Using Memoization
     * 
     * This problem is similar to unbounded knapsack problem
     * 
     * TC: O(N x S)
     * SC: O(N)
     */
    private int solveMemoization(int n, int[] coins, int sum, int[][] memo) {
        // Base Case
        if (sum == 0 && n == 0) {
            return 1;
        }
        if (sum == 0 && n != 0) {
            return 1;
        }
        if (sum != 0 && n == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[n][sum] != -1) {
            return memo[n][sum];
        }
        // Recursion Calls
        if (coins[n - 1] <= sum) {
            // we have two choices - pick and not pick
            int pick = solveMemoization(n, coins, sum - coins[n - 1], memo); // infinite supply
            int notpick = solveMemoization(n - 1, coins, sum, memo);
            return memo[n][sum] = pick + notpick;
        } else {
            // we don't have an option to pick here
            return memo[n][sum] = solveMemoization(n - 1, coins, sum, memo);
        }
    }
    
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int countRecursion(int coins[], int sum) {
        int n = coins.length;
        return solveRecursion(n, coins, sum);
    }
    
    /**
     * Using Recursion
     * 
     * This problem is similar to unbounded knapsack problem
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n, int[] coins, int sum) {
        // Base Case
        if (sum == 0 && n == 0) {
            return 1;
        }
        if (sum == 0 && n != 0) {
            return 1;
        }
        if (sum != 0 && n == 0) {
            return 0;
        }
        // Recursion Calls
        if (coins[n - 1] <= sum) {
            // we have two choices - pick and not pick
            int pick = solveRecursion(n, coins, sum - coins[n - 1]); // infinite supply
            int notpick = solveRecursion(n - 1, coins, sum);
            return pick + notpick;
        } else {
            // we don't have an option to pick here
            return solveRecursion(n - 1, coins, sum);
        }
    }
}
