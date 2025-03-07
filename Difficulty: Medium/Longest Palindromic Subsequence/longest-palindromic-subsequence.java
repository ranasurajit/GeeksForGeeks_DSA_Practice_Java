//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    /**
     * Approach II : Using Memoization
     * 
     * TC: O(N x N) ~ O(N ^ 2)
     * SC: O(N x N + N + N) ~ O(N ^ 2 + N)
     */
    public int longestPalinSubseq(String s) {
        int n = s.length();
        String t = reverse(s, n);
        // initialization of memory
        int[][] memo = new int[n + 1][n + 1]; // SC: O(M x N)
        for (int[] memoItems : memo) {
            Arrays.fill(memoItems, -1);
        }
        return solveMemoization(s, t, n, n, memo);
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(N x N)
     * SC: O(N + N)
     */
    private static int solveMemoization(String s1, String s2, int m, int n, int[][] memo) {
        // Base Case
        if (m == 0 || n == 0) {
            // nothing remains in common
            return 0;
        }
        // Memoization Check
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // Recursion Calls
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + solveMemoization(s1, s2, m - 1, n - 1, memo);
        } else {
            return memo[m][n] = Math.max(solveMemoization(s1, s2, m - 1, n, memo),
                solveMemoization(s1, s2, m, n - 1, memo));
        }
    }

    /**
     * Approach I : Using Recursion
     * 
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     */
    public int longestPalinSubseqRecursion(String s) {
        int n = s.length();
        String t = reverse(s, n);
        return solveRecursion(s, t, n, n);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ (M + N))
     * SC: O(M + N)
     */
    private static int solveRecursion(String s1, String s2, int m, int n) {
        // Base Case
        if (m == 0 || n == 0) {
            // nothing remains in common
            return 0;
        }
        // Recursion Calls
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + solveRecursion(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(solveRecursion(s1, s2, m - 1, n),
                solveRecursion(s1, s2, m, n - 1));
        }
    }
    
    /**
     * TC: O(N / 2)
     * SC: O(N)
     */
    private String reverse(String s, int n) {
        int start = 0;
        int end = n - 1;
        char[] ch = s.toCharArray();
        while (start < end) {
            char temp = ch[end];
            ch[end] = ch[start];
            ch[start] = temp;
            start++;
            end--;
        }
        return String.valueOf(ch);
    }
}
