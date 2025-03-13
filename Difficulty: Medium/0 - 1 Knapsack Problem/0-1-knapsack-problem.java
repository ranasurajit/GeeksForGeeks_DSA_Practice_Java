//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    /**
     * Approach IV : Using Space Optimization Approach
     * 
     * TC: O(N x W)
     * SC: O(2 x W) ~ O(W)
     */
    static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        // Initialization
        int[] current = new int[W + 1];
        int[] prev = new int[W + 1];
        // Iterative Call - convert dp[i] as current and dp[i - 1] as prev
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            for (int j = 1; j < W + 1; j++) { // TC: O(W)
                if (wt[i - 1] <= j) {
                    // we have two options - pick or not pick so take Maximum of them
                    current[j] = Math.max((val[i - 1] + prev[j - wt[i - 1]]), prev[j]);
                } else {
                    // we certainly cannot pick as picking the item goes beyond knapsack capacity
                    current[j] = prev[j];
                }
            }
            prev = current.clone();
        }
        return prev[W];
    }
    
    /**
     * Approach III : Using Tabulation Approach
     * 
     * TC: O(N + W + N x W) ~ O(N x W)
     * SC: O(N x W)
     */
    static int knapsackTabulation(int W, int val[], int wt[]) {
        int n = wt.length;
        // Initialization
        int[][] dp = new int[n + 1][W + 1]; // as n and W are the states - SC: O(N x W)
        for (int i = 0; i < n + 1; i++) { // TC: O(N)
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) { // TC: O(W)
            dp[0][j] = 0;
        }
        // Iterative Call - convert (n, W) to (i, j)
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            for (int j = 1; j < W + 1; j++) { // TC: O(W)
                if (wt[i - 1] <= j) {
                    // we have two options - pick or not pick so take Maximum of them
                    dp[i][j] = Math.max((val[i - 1] + dp[i - 1][j - wt[i - 1]]),
                        dp[i - 1][j]);
                } else {
                    // we certainly cannot pick as picking the item goes beyond knapsack capacity
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
    
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N x W)
     * SC: O(N x W + (N + W))
     */
    static int knapsackMemoization(int W, int val[], int wt[]) {
        int n = wt.length;
        int[][] memo = new int[n + 1][W + 1]; // as n and W are the states - SC: O(N x W)
        for (int i = 0; i < n + 1; i++) { // TC: O(N)
            for (int j = 0; j < W + 1; j++) { // TC: O(W)
                memo[i][j] = -1;
            }
        }
        return solveMemoization(n, W, val, wt, memo);
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N x W)
     * SC: O(N + W)
     */
    private static int solveMemoization(int n, int W, int[] val, int[] wt, int[][] memo) {
        // Base Case
        if (n == 0 || W == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[n][W] != -1) {
            return memo[n][W];
        }
        // Recursion Calls
        if (wt[n - 1] <= W) {
            // we have two options - pick or not pick
            // pick
            int pick = val[n - 1] + solveMemoization(n - 1, W - wt[n - 1], val, wt, memo);
            // not pick
            int notpick = solveMemoization(n - 1, W, val, wt, memo);
            return memo[n][W] = Math.max(pick, notpick);
        } else {
            // we certainly cannot pick as picking the item goes beyond knapsack capacity
            return memo[n][W] = solveMemoization(n - 1, W, val, wt, memo);
        }
    }
    
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    static int knapsackRecursion(int W, int val[], int wt[]) {
        int n = wt.length;
        return solveRecursion(n, W, val, wt);
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static int solveRecursion(int n, int W, int[] val, int[] wt) {
        // Base Case
        if (n == 0 || W == 0) {
            return 0;
        }
        // Recursion Calls
        if (wt[n - 1] <= W) {
            // we have two options - pick or not pick
            // pick
            int pick = val[n - 1] + solveRecursion(n - 1, W - wt[n - 1], val, wt);
            // not pick
            int notpick = solveRecursion(n - 1, W, val, wt);
            return Math.max(pick, notpick);
        } else {
            // we certainly cannot pick as picking the item goes beyond knapsack capacity
            return solveRecursion(n - 1, W, val, wt);
        }
    }
}
