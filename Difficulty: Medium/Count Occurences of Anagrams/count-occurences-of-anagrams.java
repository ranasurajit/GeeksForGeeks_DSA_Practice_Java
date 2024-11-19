//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N + K)
     * SC: O(1)
     */
    int search(String pat, String txt) {
        int k = pat.length();
        int[] chars = new int[26];
        for (int i = 0; i < k; i++) { // TC: O(K)
            chars[pat.charAt(i) - 'a']++;
        }
        int n = txt.length();
        int count = 0;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            chars[txt.charAt(j) - 'a']--;
            if (j - i + 1 == k) {
                if (containsAllZeros(chars)) {
                    count++;
                }
                chars[txt.charAt(i) - 'a']++;
                i++;
            }
        }
        return count;
    }
    
    /**
     * TC: O(26)
     * SC: O(1)
     */
    private boolean containsAllZeros(int[] chars) {
        for (int ch : chars) {
            if (ch != 0) {
                return false;
            }
        }
        return true;
    }
}
