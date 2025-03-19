//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach I : Using Memoization Approach
     * 
     * TC: O(N x K)
     * SC: O(N x K + N)
     */
    static int maxProfit(int prices[], int k) {
        int n = prices.length;
        int[][][] memo = new int[n + 1][k + 1][2]; // SC: O(N x K)
        for (int[][] memoItem : memo) {
            for (int[] mem : memoItem) {
                Arrays.fill(mem, -1);
            }
        }
        return solveMemoization(0, n, k, prices, 1, memo);
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(N x K)
     * SC: O(N)
     */
    private static int solveMemoization(int index, int n, int k, 
        int[] prices, int buy, int[][][] memo) {
        // Base Case
        if (index == n || k == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[index][k][buy] != -1) {
            return memo[index][k][buy];
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy == 1) {
            // we can buy - pick or not pick
            pick = -prices[index] + solveMemoization(index + 1, n, k, prices, 0, memo);
            notpick = solveMemoization(index + 1, n, k, prices, 1, memo);
        } else {
            // we can sell - pick or not pick - transaction is counted
            pick = prices[index] + solveMemoization(index + 1, n, k - 1, prices, 1, memo);
            notpick = solveMemoization(index + 1, n, k, prices, 0, memo);
        }
        return memo[index][k][buy] = Math.max(pick, notpick);
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    static int maxProfitRecursion(int prices[], int k) {
        int n = prices.length;
        return solveRecursion(0, n, k, prices, true);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static int solveRecursion(int index, int n, int k, int[] prices, boolean buy) {
        // Base Case
        if (index == n || k == 0) {
            return 0;
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy) {
            // we can buy - pick or not pick
            pick = -prices[index] + solveRecursion(index + 1, n, k, prices, false);
            notpick = solveRecursion(index + 1, n, k, prices, true);
        } else {
            // we can sell - pick or not pick - transaction is counted
            pick = prices[index] + solveRecursion(index + 1, n, k - 1, prices, true);
            notpick = solveRecursion(index + 1, n, k, prices, false);
        }
        return Math.max(pick, notpick);
    }
}
