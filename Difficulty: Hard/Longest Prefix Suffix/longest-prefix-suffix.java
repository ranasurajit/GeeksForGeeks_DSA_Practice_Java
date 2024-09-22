//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(|str|)
     * SC: O(1)
     */
    int lps(String str) {
        int i = 0; // prefix can range from position 0 to n - 2
        int j = 1; // suffix can range from position 1 to n - 1
        int count = 0;
        int position = 1; // position of last match
        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                count++;
                i++;
                j++;
            } else {
                i = 0;
                count = 0;
                position++;
                j = position;
            }
        }
        return count;
    }
}
