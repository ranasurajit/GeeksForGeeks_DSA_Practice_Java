//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    private int[][] numpad = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 },
        { -1, 0, -1 }
    };
    
    public long getCount(int n) {
        long[][] dp = new long[10][n + 1];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }
        long count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (numpad[i][j] != -1) {
                    count += solve(i, j, n, dp);
                }
            }
        }
        return count;
    }
    
    private long solve(int i, int j, int n, long[][] dp) {
        if (n == 1) {
            return 1;
        }
        if (dp[numpad[i][j]][n] != -1) {
            return dp[numpad[i][j]][n];
        }
        long a = solve(i, j, n - 1, dp);
        long b = 0;
        long c = 0;
        long d = 0;
        long e = 0;
        
        if (j >= 1 && numpad[i][j - 1] != -1) {
            b = solve(i, j - 1, n - 1, dp);
        }
        if (j < 2 && numpad[i][j + 1] != -1) {
            c = solve(i, j + 1, n - 1, dp);
        }
        if (i >= 1 && numpad[i - 1][j] != -1) {
            d = solve(i - 1, j, n - 1, dp);
        }
        if (i < 3 && numpad[i + 1][j] != -1) {
            e = solve(i + 1, j, n - 1, dp);
        }
        dp[numpad[i][j]][n] = (a + b + c + d + e);
        return dp[numpad[i][j]][n];
    }
}
