//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N + N)
     */
    public int countWays(String digits) {
        int n = digits.length();
        int[] memo = new int[n + 1]; // SC: O(N)
        Arrays.fill(memo, -1);
        return solveMemoization(0, n, digits, memo); // TC: O(N), SC: O(N)
    }
    
    /**
     * Using Memoization
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveMemoization(int index, int n, String digits, int[] memo) {
        // Base Case
        if (index == n) {
            return 1;
        }
        if (index < n && digits.charAt(index) == '0') {
            return 0;
        }
        // Memoization Check
        if (memo[index] != -1) {
            return memo[index];
        }
        // Recursion Calls
        // we can either atmost 2 characters of digits (as we can decode from 1 to 26 characters)
        int ways1 = solveMemoization(index + 1, n, digits, memo);
        int ways2 = 0;
        if (index < n - 1 && ((digits.charAt(index) - '0') == 1 || 
            (digits.charAt(index) - '0') == 2 && 
             (digits.charAt(index + 1) - '0') <= 6)) {
            // if number <= 26 then only decoding is possible
            ways2 = solveMemoization(index + 2, n, digits, memo);
        }
        return memo[index] = ways1 + ways2;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int countWaysRecursion(String digits) {
        int n = digits.length();
        return solveRecursion(0, n, digits);
    }
    
    /**
     * Using Recursion
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int index, int n, String digits) {
        // Base Case
        if (index == n) {
            return 1;
        }
        if (index < n && digits.charAt(index) == '0') {
            return 0;
        }
        // Recursion Calls
        // we can either atmost 2 characters of digits (as we can decode from 1 to 26 characters)
        int ways1 = solveRecursion(index + 1, n, digits);
        int ways2 = 0;
        if (index < n - 1 && ((digits.charAt(index) - '0') == 1 || 
            (digits.charAt(index) - '0') == 2 && 
             (digits.charAt(index + 1) - '0') <= 6)) {
            // if number <= 26 then only decoding is possible
            ways2 = solveRecursion(index + 2, n, digits);
        }
        return ways1 + ways2;
    }
}
