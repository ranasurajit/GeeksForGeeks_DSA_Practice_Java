//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N)
     * SC: O(2 x N)
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] memo = new int[n + 1][2][k + 1]; // SC: O(6 x N) ~ O(N)
        for (int[][] memoItem : memo) {
            for (int[] mem : memoItem) {
                Arrays.fill(mem, -1);
            }
        }
        return solveRecursion(0, n, prices, 1, 2, memo);
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(N x 2 x 3) ~ O(6 x N) ~ O(N)
     * SC: O(N)
     */
    private static int solveRecursion(int index, int n, int[] prices,
        int buy, int k, int[][][] memo) {
        // Base Case
        if (index == n || k == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[index][buy][k] != -1) {
            return memo[index][buy][k];
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy == 1) {
            pick = -1 * prices[index] + solveRecursion(index + 1, n, prices, 0, k, memo);
            notpick = solveRecursion(index + 1, n, prices, 1, k, memo);
        } else {
            pick = prices[index] + solveRecursion(index + 1, n, prices, 1, k - 1, memo);
            notpick = solveRecursion(index + 1, n, prices, 0, k, memo);
        }
        return memo[index][buy][k] = Math.max(pick, notpick);
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public static int maxProfitRecursion(int[] prices) {
        int n = prices.length;
        return solveRecursion(0, n, prices, 1, 2);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static int solveRecursion(int index, int n, int[] prices, int buy, int k) {
        // Base Case
        if (index == n || k == 0) {
            return 0;
        }
        // Recursion Calls
        int pick = 0;
        int notpick = 0;
        if (buy == 1) {
            pick = -1 * prices[index] + solveRecursion(index + 1, n, prices, 0, k);
            notpick = solveRecursion(index + 1, n, prices, 1, k);
        } else {
            pick = prices[index] + solveRecursion(index + 1, n, prices, 1, k - 1);
            notpick = solveRecursion(index + 1, n, prices, 0, k);
        }
        return Math.max(pick, notpick);
    }
}
