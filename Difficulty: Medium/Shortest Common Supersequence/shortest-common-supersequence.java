//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        sc.nextLine();
        while (t-- > 0) {
            // taking String X and Y
            String X = sc.nextLine();
            String Y = sc.nextLine();

            // calling function shortestCommonSupersequence()
            System.out.println(new Solution().shortestCommonSupersequence(X, Y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find length of shortest common supersequence of two strings.
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(M x N)
     * SC: O(M x N)
     */
    public static int shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        return solveMemoization(s1, s2, m, n, memo);
    }
    
    private static int solveMemoization(String s1, String s2, int m, int n, int[][] memo) {
        // Base case
        if (m == 0 || n == 0) {
            return m + n;
        }
        // Memoization Check
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // Recursive calls
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + solveMemoization(s1, s2, m - 1, n - 1, memo);
        } else {
            return memo[m][n] = 1 + Math.min(solveMemoization(s1, s2, m - 1, n, memo), 
                solveMemoization(s1, s2, m, n - 1, memo));
        }
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     */
    public static int shortestCommonSupersequenceApproachI(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        return solveRecursion(s1, s2, m, n);
    }
    
    private static int solveRecursion(String s1, String s2, int m, int n) {
        // Base case
        if (m == 0 || n == 0) {
            return m + n;
        }
        // Recursive calls
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + solveRecursion(s1, s2, m - 1, n - 1);
        } else {
            return 1 + Math.min(solveRecursion(s1, s2, m - 1, n), 
                solveRecursion(s1, s2, m, n - 1));
        }
    }
}
