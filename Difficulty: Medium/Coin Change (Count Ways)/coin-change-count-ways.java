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
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using Memoization
     * 
     * TC: O(N x W + N)
     * SC: O(N x W + N)
     * 
     * @param coins
     * @param sum
     * @return
     */
    public int count(int coins[], int sum) {
        int n = coins.length;
        int[][] memo = new int[n + 1][sum + 1];
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        return solveMemoization(coins, sum, n, memo);
    }
    
    /**
     * Using Memoization
     * 
     * This problem is similar to knapsack subset-sum problem
     * 
     * TC: O(N x W)
     * SC: O(N x W + N)
     */
    private int solveMemoization(int[] coins, int w, int n, int[][] memo) {
        // Base case
        if (n == 0 && w == 0) {
            return 1;
        } else if (n == 0 && w != 0) {
            return 0;
        } else if (n != 0 && w == 0) {
            return 1;
        }
        // Memoization call
        if (memo[n][w] != -1) {
            return memo[n][w];
        }
        // Recursion calls
        if (coins[n - 1] <= w) {
            // we have two choices whether to pick or not pick a coin
            int pick = solveMemoization(coins, w - coins[n - 1], n, memo);
            // we can pick multiple times any coin
            int notpick = solveMemoization(coins, w, n - 1, memo);
            return memo[n][w] = pick + notpick;
        } else {
            // we cannot pick this coin
            return memo[n][w] = solveMemoization(coins, w, n - 1, memo);
        }
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(2 ^ N)
     * 
     * @param coins
     * @param sum
     * @return
     */
    public int countRecursion(int coins[], int sum) {
        int n = coins.length;
        return solveRecursion(coins, sum, n);
    }
    
    /**
     * Using Recursion
     * 
     * This problem is similar to knapsack subset-sum problem
     * 
     * TC: O(2 ^ N)
     * SC: O(2 ^ N)
     */
    private int solveRecursion(int[] coins, int w, int n) {
        // Base case
        if (n == 0 && w == 0) {
            return 1;
        } else if (n == 0 && w != 0) {
            return 0;
        } else if (n != 0 && w == 0) {
            return 1;
        }
        // Recursion calls
        if (coins[n - 1] <= w) {
            // we have two choices whether to pick or not pick a coin
            int pick = solveRecursion(coins, w - coins[n - 1], n);
            // we can pick multiple times any coin
            int notpick = solveRecursion(coins, w, n - 1);
            return pick + notpick;
        } else {
            // we cannot pick this coin
            return solveRecursion(coins, w, n - 1);
        }
    }
}
