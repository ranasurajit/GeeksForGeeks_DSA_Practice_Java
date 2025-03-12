//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N)
     * SC: O(2 x N)
     */
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return Math.min(
            solveMemoization(0, cost, n, memo),
            solveMemoization(1, cost, n, memo)
        );
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N)
     * SC: O(N + N)
     */
    private static int solveMemoization(int index, int[] cost, int n, int[] memo) {
        // Base Case
        if (index >= n) {
            return 0;
        }
        // Memoization Check
        if (memo[index] != -1) {
            return memo[index];
        }
        // Recursion Calls
        return memo[index] = Math.min(
            cost[index] + solveMemoization(index + 1, cost, n, memo),
            cost[index] + solveMemoization(index + 2, cost, n, memo)
        );
    }
    
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(N)
     */
    static int minCostClimbingStairsRecursion(int[] cost) {
        int n = cost.length;
        return Math.min(solveRecursion(0, cost, n), solveRecursion(1, cost, n));
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(N)
     */
    private static int solveRecursion(int index, int[] cost, int n) {
        // Base Case
        if (index >= n) {
            return 0;
        }
        // Recursion Calls
        return Math.min(
            cost[index] + solveRecursion(index + 1, cost, n),
            cost[index] + solveRecursion(index + 2, cost, n)
        );
    }
};
