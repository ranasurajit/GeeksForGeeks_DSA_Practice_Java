//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Approach V : Using Greedy Approach
     *
     * TC: O(N)
     * SC: O(1)
     * 
     * Test Cases Passed: (1111 /1111)
     */
    static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        if (arr[0] == 0) {
            // can never reach
            return -1;
        }
        int steps = arr[0];
        int maxReach = arr[0];
        int jumps = 1;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                return jumps;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return -1;
    }
    
    /**
     * Approach IV : Using Greedy Approach
     *
     * TC: O(N)
     * SC: O(1)
     * 
     * Test Cases Passed: (1111 /1111)
     */
    static int minJumpsGreedy(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = 0;
        int jumps = 0;
        while (high < n - 1) {
            int farthest = 0;
            for (int i = low; i <= high; i++) {
                farthest = Math.max(farthest, arr[i] + i);
            }
            low = high + 1;
            high = farthest;
            jumps++;
        }
        return jumps;
    }

    /**
     * Approach III : Using Tabulation Approach
     *
     * TC: O(N x K)
     * SC: O(N)
     * 
     * where K = Max(arr)
     * Test Cases Passed: (1111 /1111)
     */
    static int minJumpsTabulation(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // SC: O(N)
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int i = 1; i < n; i++) { // TC: O(N)
            int minStep = (int) 1e9;
            for (int k = 0; k < i; k++) { // TC: O(K)
                if (k + arr[k] >= i) {
                    minStep = Math.min(minStep, 1 + dp[k]);
                }
            }
            if (minStep != (int) 1e9) {
                dp[i] = minStep;
            }
        }
        return dp[n - 1] == (int) 1e9 ? -1 : dp[n - 1];
    }

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N x K)
     * SC: O(N + N)
     * 
     * where K = Max(arr)
     * Test Cases Passed: (1111 /1111)
     */
    static int minJumpsMemoization(int[] arr) {
        int n = arr.length;
        int[] memo = new int[n + 1]; // SC: O(N)
        Arrays.fill(memo, -1);
        int jumps = solveMemoization(0, n, arr, memo);
        return jumps >= (int) 1e9 ? -1 : jumps;
    }

    /**
     * Using Memoization
     *
     * TC: O(N x K)
     * SC: O(N)
     * 
     * where K = Max(arr)
     */
    private static int solveMemoization(int idx, int n, int[] arr, int[] memo) {
        // Base Case
        if (idx >= n) {
            return (int) 1e9;
        }
        if (idx == n - 1) {
            return 0;
        }
        // Memoization Check
        if (memo[idx] != -1) {
            return memo[idx];
        }
        // Recursion Calls
        int k = arr[idx];
        int minJumps = (int) 1e9;
        for (int i = 1; i <= k; i++) {
            minJumps = Math.min(minJumps, solveMemoization(idx + i, n, arr, memo));
        }
        return memo[idx] = 1 + minJumps;
    }
    
    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(K ^ N)
     * SC: O(N)
     * 
     * where K = Max(arr)
     * Test Cases Passed: (10 /1111)
     */
    static int minJumpsRecursion(int[] arr) {
        int n = arr.length;
        int jumps = solveRecursion(0, n, arr);
        return jumps >= (int) 1e9 ? -1 : jumps;
    }
    
    /**
     * Using Recursion
     *
     * TC: O(K ^ N)
     * SC: O(N)
     * 
     * where K = Max(arr)
     */
    private static int solveRecursion(int idx, int n, int[] arr) {
        // Base Case
        if (idx >= n) {
            return (int) 1e9;
        }
        if (idx == n - 1) {
            return 0;
        }
        // Recursion Calls
        int k = arr[idx];
        int minJumps = (int) 1e9;
        for (int i = 1; i <= k; i++) {
            minJumps = Math.min(minJumps, solveRecursion(idx + i, n, arr));
        }
        return 1 + minJumps;
    }
}
