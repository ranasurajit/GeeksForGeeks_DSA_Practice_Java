//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
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
     * TC: O((N + 1) x 2 ^ N) ~ O(N x 2 ^ N)
     * SC: O(2 x N) ~ O(N)
     */
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        int ones = 0;
        int zeroes = 0;
        solveRecursion(ones, zeroes, N, sb, result); // TC: O(2 ^ N), SC: O(N)
        // TC: O(2 ^ N x log(2 ^ N)) ~ O(N x 2 ^ N)
        result.sort((a, b) -> Double.compare(Double.parseDouble(b), Double.parseDouble(a)));
        return result;
    }
    
    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int ones, int zeroes, int n, StringBuilder sb,
        ArrayList<String> result) {
        // Base Case
        if (n == 0) {
            result.add(sb.toString());
            return;
        }
        // Recursion Calls
        // we may choose 1 or 0 (if ones > zeroes)
        // choose 0
        if (ones > zeroes) {
            sb.append('0');
            solveRecursion(ones, zeroes + 1, n - 1, sb, result);
            sb.setLength(sb.length() - 1); // backtrack
        }
        // choose 1
        sb.append('1');
        solveRecursion(ones + 1, zeroes, n - 1, sb, result);
        sb.setLength(sb.length() - 1); // backtrack
    }
}
