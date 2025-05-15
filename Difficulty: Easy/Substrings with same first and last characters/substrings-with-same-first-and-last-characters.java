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
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int countSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26]; // SC: O(26) ~ O(1)
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[s.charAt(i) - 'a']++;
            count += freq[s.charAt(i) - 'a'];
        }
        return count;
    }
}
