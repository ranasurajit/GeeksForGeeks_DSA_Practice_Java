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
     * Approach II : Using Memoization Approach
     *
     * TC: O(N + N x T) ~ O(N x T)
     * SC: O(N x T + N)
     */
    static boolean equalPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            // odd sum cannot be partioned to form two equal sum subsets
            return false;
        }
        int target = sum / 2;
        int[][] memo = new int[n + 1][target + 1]; // SC: O(N x T)
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        // now the problem gets converted to subset sum problem where target = sum / 2
        return solveMemoization(n, arr, target, memo);
    }
    
    /**
     * Using Memoization Approach
     *
     * TC: O(N x T)
     * SC: O(N)
     */
    private static boolean solveMemoization(int n, int[] arr, int target, int[][] memo) {
        // Base Case
        if (target == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // Memoization Check
        if (memo[n][target] != -1) {
            return memo[n][target] == 1;
        }
        // Recursive Calls
        if (arr[n - 1] <= target) {
            // we have options to pick or not pick
            Boolean pick = solveMemoization(n - 1, arr, target - arr[n - 1], memo);
            Boolean notpick = solveMemoization(n - 1, arr, target, memo);
            Boolean result = pick || notpick;
            memo[n][target] = result ? 1 : 0;
            return result;
        } else {
            // we don't have an option to pick anyways
            Boolean result = solveMemoization(n - 1, arr, target, memo);
            memo[n][target] = result ? 1 : 0;
            return result;
        }
    }
    
    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N + 2 ^ N) ~ O(2 ^ N)
     * SC: O(N)
     */
    static boolean equalPartitionRecursion(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            // odd sum cannot be partioned to form two equal sum subsets
            return false;
        }
        int target = sum / 2;
        // now the problem gets converted to subset sum problem where target = sum / 2
        return solveRecursion(n, arr, target);
    }
    
    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static boolean solveRecursion(int n, int[] arr, int target) {
        // Base Case
        if (target == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // Recursive Calls
        if (arr[n - 1] <= target) {
            // we have options to pick or not pick
            Boolean pick = solveRecursion(n - 1, arr, target - arr[n - 1]);
            Boolean notpick = solveRecursion(n - 1, arr, target);
            return pick || notpick;
        } else {
            // we don't have an option to pick anyways
            return solveRecursion(n - 1, arr, target);
        }
    }
}
