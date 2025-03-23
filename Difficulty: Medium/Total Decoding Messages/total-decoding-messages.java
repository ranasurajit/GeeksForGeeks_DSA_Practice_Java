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


// User function Template for Java
class Solution {
    /**
     * Approach IV : Using Space Optimization Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int countWays(String digits) {
        int n = digits.length();
        int prev2 = 1;
        int prev1 = digits.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int singleDigit = Integer.parseInt(digits.substring(i - 1, i));
            int current = 0;
            if (singleDigit >= 1 && singleDigit <= 9) {
                current += prev1;
            }
            int doubleDigit = Integer.parseInt(digits.substring(i - 2, i));
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                // if number <= 26 then only decoding is possible
                current += prev2;
            }
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    /**
     * Approach III : Using Tabulation Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int countWaysTabulation(String digits) {
        int n = digits.length();
        int[] dp = new int[n + 1]; // SC: O(N)
        dp[0] = 1; // reverse of if (index == n) return 1;
        dp[1] = digits.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int singleDigit = Integer.parseInt(digits.substring(i - 1, i));
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            int doubleDigit = Integer.parseInt(digits.substring(i - 2, i));
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                // if number <= 26 then only decoding is possible
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(N)
     * SC: O(N + N)
     */
    public int countWaysMemoization(String digits) {
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
