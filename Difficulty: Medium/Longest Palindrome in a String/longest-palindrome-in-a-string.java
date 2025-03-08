//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    /**
     * Using String Manipulation
     * 
     * TC: O(2 x N ^ 2) ~ O(N ^ 2)
     * SC: O(1)
     */
    static String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        /**
         * Consider each character as mid of palindrome
         */
        // for odd length at index i we need compare (i - 1) and (i + 1)th character
        for (int i = 0; i < n; i++) { // TC: O(N)
            int currentLength = 1 + getLength(i - 1, i + 1, s); // TC: O(N)
            if (maxLength < currentLength) {
                maxLength = currentLength;
                start = i - currentLength / 2;
            }
        }
        // for even length at index i we need compare (i - 1) and (i)th character
        for (int i = 1; i < n; i++) { // TC: O(N)
            int currentLength = getLength(i - 1, i, s); // TC: O(N)
            if (maxLength < currentLength) {
                maxLength = currentLength;
                start = i - currentLength / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static int getLength(int p, int q, String s) {
        int len = 0;
        while (p >= 0 && q < s.length()) {
            if (s.charAt(p) == s.charAt(q)) {
                len += 2;
                p--;
                q++;
            } else {
                break;
            }
        }
        return len;
    }
}
