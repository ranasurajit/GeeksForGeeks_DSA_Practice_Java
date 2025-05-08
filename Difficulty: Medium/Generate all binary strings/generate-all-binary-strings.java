//{ Driver Code Starts
//Initial Template for Java

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
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(2 x N) ~ O(N)
     */
    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        solveRecursion(0, n, sb, result); // TC: O(2 ^ N), SC: O(N)
        return result;
    }
    
    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static void solveRecursion(int idx, int n, StringBuilder sb, List<String> result) {
        // Base Case
        if (idx == n) {
            result.add(sb.toString());
            return;
        }
        // Recursion Calls
        // take 0 or 1 (condition based)
        // take 0
        sb.append('0');
        solveRecursion(idx + 1, n, sb, result);
        sb.setLength(sb.length() - 1); // backtrack
        // take 1
        if (sb.length() == 0 || sb.charAt(idx - 1) != '1') {
            sb.append('1');
            solveRecursion(idx + 1, n, sb, result);
            sb.setLength(sb.length() - 1); // backtrack
        }
    }
}
