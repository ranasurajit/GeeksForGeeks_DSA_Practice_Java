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


class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N x T)
     * SC: O(N x T + N)
     */
    static boolean equalPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            // if sum is odd then equal subset sum partition is not possible
            return false;
        }
        // we need to find of a subset is possible to have sum of elements = sum / 2
        sum = sum / 2;
        int[][] memo = new int[n + 1][sum + 1]; // SC: O(N x T)
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        return solveMemoization(n, arr, sum, memo);
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(N x T)
     * SC: O(N)
     */
    private static boolean solveMemoization(int n, int[] arr, int sum, int[][] memo) {
        // Base Case
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // Memoization Check
        if (memo[n][sum] != -1) {
            return memo[n][sum] == 1;
        }
        // Recursion Calls
        if (arr[n - 1] <= sum) {
            // we have two options pick or not pick
            boolean pick = solveMemoization(n - 1, arr, sum - arr[n - 1], memo);
            boolean notpick = solveMemoization(n - 1, arr, sum, memo);
            boolean result = pick || notpick;
            memo[n][sum] = result ? 1 : 0;
            return result;
        } else {
            // we don't have an option to pick
            boolean result = solveMemoization(n - 1, arr, sum, memo);
            memo[n][sum] = result ? 1 : 0;
            return result;
        }
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    static boolean equalPartitionRecursion(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            // if sum is odd then equal subset sum partition is not possible
            return false;
        }
        // we need to find of a subset is possible to have sum of elements = sum / 2
        sum = sum / 2;
        return solveRecursion(n, arr, sum);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static boolean solveRecursion(int n, int[] arr, int sum) {
        // Base Case
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // Recursion Calls
        if (arr[n - 1] <= sum) {
            // we have two options pick or not pick
            boolean pick = solveRecursion(n - 1, arr, sum - arr[n - 1]);
            boolean notpick = solveRecursion(n - 1, arr, sum);
            return pick || notpick;
        } else {
            // we don't have an option to pick
            return solveRecursion(n - 1, arr, sum);
        }
    }
}
