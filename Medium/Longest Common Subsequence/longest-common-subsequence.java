//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt(); // Take size of both the strings as input
            int m = sc.nextInt();

            String str1 = sc.next(); // Take both the string as input
            String str2 = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.lcs(n, m, str1, str2));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String str1, String str2) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsHelper(n, m, str1, str2, dp);
    }
    
    static int lcsHelper(int n, int m, String str1, String str2, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = 1 + lcsHelper(n - 1, m - 1, str1, str2, dp);
        } else {
            return dp[n][m] = Math.max(
                lcsHelper(n, m - 1, str1, str2, dp), 
                lcsHelper(n - 1, m, str1, str2, dp)
            );
        }
    }
}
