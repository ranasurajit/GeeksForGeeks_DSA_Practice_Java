//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        // using memoization to decrease Time complexity
        int[][] dp = new int[n1 + 1][n2 + 1];
        return getNumOperations(str1, n1, str2, n2, dp);
    }
    
    private int getNumOperations(String str1, int n1, String str2, int n2, int[][] dp) {
        // base case
        if (n1 == 0) {
            // n1 length is exhaused and to match we need n2 more operations
            return n2;
        }
        if (n2 == 0) {
            // n2 length is exhaused and to match we need n1 more operations
            return n1;
        }
        if (dp[n1][n2] != 0) {
            return dp[n1][n2];
        }
        // if characters at any index matches between str1 and str2
        if (str1.charAt(n1 - 1) == str2.charAt(n2 - 1)) {
            // we reduce size by 1 for both str1 and str2 as respective index characters match
            return dp[n1][n2] = getNumOperations(str1, n1 - 1, str2, n2 - 1, dp);
        } else {
            /**
             * if we add a character to str1 to match then we do 
             * 1 add operation and decrement n2
             */
            int add = 1 + getNumOperations(str1, n1, str2, n2 - 1, dp);
            /**
             * if we remove a character from str1 to match then we do 
             * 1 remove operation and decrement n1
             */
            int remove = 1 + getNumOperations(str1, n1 - 1, str2, n2, dp);
            /**
             * if we replace a character from str1 to match then we do 
             * 1 replace operation and decrement n1 and n2
             */
            int replace = 1 + getNumOperations(str1, n1 - 1, str2, n2 - 1, dp);
            return dp[n1][n2] = Math.min(add, Math.min(remove, replace));
        }
    }
}
