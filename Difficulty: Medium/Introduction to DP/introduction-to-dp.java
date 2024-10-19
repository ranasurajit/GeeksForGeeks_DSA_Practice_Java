//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static final long mod = 1000000007;
    /**
     * TC: O(N)
     * SC: O(2N) ~ O(N)
     */
    static long topDown(int n) {
        long[] dp = new long[n + 1]; // SC: O(N)
        // Arrays.fill(dp, -1L);
        solve(n, dp);
        return dp[n];
    }
    
    private static long solve(int n, long[] dp) {
        if (n <= 1) {
            return dp[n] = (long) n;
        }
        if (dp[n] != 0) {
            return dp[n] % mod;
        }
        return dp[n] = ((solve(n - 1, dp) % mod + solve(n - 2, dp) % mod)) % mod;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    static long bottomUp(int n) {
        long[] dp = new long[n + 1]; // SC: O(N)
        dp[0] = 0L;
        dp[1] = 1L;
        for (int i = 2; i <= n; i++) { // TC: O(N)
            dp[i] = (dp[i - 1] % mod + (long) dp[i - 2] % mod) % mod;
        }
        return dp[n];
    }
}
