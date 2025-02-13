//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Using Memoization
     * 
     * TC: O(N x W + N)
     * SC: O(N x W + N)
     * 
     * @param price
     * @return
     */
    public int cutRod(int[] price) {
        int n = price.length;
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = i + 1;
        }
        int w = n;
        int[][] memo = new int[n + 1][w + 1];
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        return solveMemoization(wt, price, w, n, memo);
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(N x W)
     * SC: O(N x W + N)
     * 
     * @param wt
     * @param val
     * @param w
     * @param n
     * @param memo
     * @return
     */
    private int solveMemoization(int[] wt, int[] val, int w, int n, int[][] memo) {
        // Base case
        if (n == 0 || w == 0) {
            return 0;
        }
        // Memoization call
        if (memo[n][w] != -1) {
            return memo[n][w];
        }
        // Recursion call
        if (wt[n - 1] <= w) {
            // we have two options whether to pick or not pick
            int pick = val[n - 1] + solveMemoization(wt, val, w - wt[n - 1], n, memo);
            int notpick = solveMemoization(wt, val, w, n - 1, memo);
            return memo[n][w] = Math.max(pick, notpick);
        } else {
            return memo[n][w] = solveMemoization(wt, val, w, n - 1, memo);
        }
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(2 ^ N)
     * 
     * @param price
     * @return
     */
    public int cutRodRecursion(int[] price) {
        int n = price.length;
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = i + 1;
        }
        int w = n;
        return solveRecursion(wt, price, w, n);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(2 ^ N)
     * 
     * @param wt
     * @param val
     * @param w
     * @param n
     * @return
     */
    private int solveRecursion(int[] wt, int[] val, int w, int n) {
        // Base case
        if (n == 0 || w == 0) {
            return 0;
        }
        // Recursion call
        if (wt[n - 1] <= w) {
            // we have two options whether to pick or not pick
            int pick = val[n - 1] + solveRecursion(wt, val, w - wt[n - 1], n);
            int notpick = solveRecursion(wt, val, w, n - 1);
            return Math.max(pick, notpick);
        } else {
            return solveRecursion(wt, val, w, n - 1);
        }
    }
}
