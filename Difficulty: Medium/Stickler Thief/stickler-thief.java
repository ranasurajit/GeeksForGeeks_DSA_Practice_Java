//{ Driver Code Starts
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

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    /**
     * Approach IV : Using Space Optimization Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int prev2 = 0;
        int prev = 0;
        int current = 0;
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            if (i > 1) {
                current = Math.max(arr[i - 1] + prev2, prev);
            } else {
                current = Math.max(arr[i - 1], prev);
            }
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    /**
     * Approach III : Using Tabulation Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int findMaxSumTabulation(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n + 1]; // SC: O(N)
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) { // TC: O(N)
            if (i > 1) {
                dp[i] = Math.max(arr[i - 1] + dp[i - 2], dp[i - 1]);
            } else {
                dp[i] = Math.max(arr[i - 1], dp[i - 1]);
            }
        }
        return dp[n];
    }

    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N)
     * SC: O(N + N)
     */
    public int findMaxSumMemoization(int arr[]) {
        int n = arr.length;
        int[] memo = new int[n + 1]; // SC: O(N)
        Arrays.fill(memo, -1);
        return solveMemoization(n, arr, memo);
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveMemoization(int n, int[] arr, int[] memo) {
        // Base Case
        if (n <= 0) {
            return 0;
        }
        // Memoization Check
        if (memo[n] != -1) {
            return memo[n];
        }
        // Recursion Calls
        int option1 = arr[n - 1] + solveMemoization(n - 2, arr, memo);
        int option2 = solveMemoization(n - 1, arr, memo);
        return memo[n] = Math.max(option1, option2);
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int findMaxSumRecursion(int arr[]) {
        int n = arr.length;
        return solveRecursion(n, arr);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n, int[] arr) {
        // Base Case
        if (n <= 0) {
            return 0;
        }
        // Recursion Calls
        int option1 = arr[n - 1] + solveRecursion(n - 2, arr);
        int option2 = solveRecursion(n - 1, arr);
        return Math.max(option1, option2);
    }
}
