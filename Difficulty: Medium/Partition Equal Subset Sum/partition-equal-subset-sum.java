//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using DP Approach
     *
     * TC: O(N x T + N)
     * SC: O(N x T + N)
     * where T = sum
     */
    static boolean equalPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            // sum is odd so equal partition is not possible
            return false;
        }
        int target = sum / 2;
        return isSubsetSum(arr, n, target); // TC: O(N x T), SC: O(N x T + N)
    }
    
    /**
     * Using DP Approach (Memoization)
     *
     * TC: O(N x T)
     * SC: O(N x T + N)
     * where T = sum
     */
    private static boolean isSubsetSum(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return solveMemoization(arr, n, sum, dp);
    }
    
    /**
     * Using Memoization
     *
     * TC: O(N x T)
     * SC: O(N x T + N)
     * where T = target
     */
    private static boolean solveMemoization(int[] arr, int n, int sum, int[][] dp) {
        // Base case
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        // memoization call
        if (dp[n][sum] != -1) {
            return dp[n][sum] == 1;
        }
        // recursion call
        if (arr[n - 1] <= sum) {
            // we have two options whether to pick or notpick
            boolean optionOne = solveMemoization(arr, n - 1, sum - arr[n - 1], dp) ||
                                solveMemoization(arr, n - 1, sum, dp);
            dp[n][sum] = optionOne ? 1 : 0;
            return optionOne;
        } else {
            // we cannot choose this option
            boolean optionTwo = solveMemoization(arr, n - 1, sum, dp);
            dp[n][sum] = optionTwo ? 1 : 0;
            return optionTwo;
        }
    }
}
