//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str) {
        // find reverse of string
        String rev = reverseStr(str);
        // find longest length of subsequence b/w str and rev
        int n = str.length();
        int subseqLen = longestSubsequence(str, rev, n, n);
        // minimum number of characters = number of adjustments needed matching str and rev
        return str.length() - subseqLen;
    }
    
    static int longestSubsequence(String str1, String str2, int n, int m) {
        // Using DP as to reduce TC and SC to O(n2)
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsHelper(str1, str2, n, m, dp);
    }
    
    static int lcsHelper(String str1, String str2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = 1 + lcsHelper(str1, str2, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(
                lcsHelper(str1, str2, n, m - 1, dp),
                lcsHelper(str1, str2, n - 1, m, dp)
            );
        }
    }
    
    static String reverseStr(String str) {
        char[] ch = str.toCharArray();
        int low = 0;
        int high = ch.length - 1;
        while (low < high) {
            char temp = ch[high];
            ch[high] = ch[low];
            ch[low] = temp;
            low++;
            high--;
        }
        return new String(ch);
    }
}
