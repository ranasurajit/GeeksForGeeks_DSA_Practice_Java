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
     * TC: O(M + N)
     * SC: O(1)
     */
    int search(String pat, String txt) {
        int n = pat.length();
        int m = txt.length();
        int[] chars = new int[26];
        for (int i = 0; i < n; i++) { // TC: O(N)
            chars[pat.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0, j = 0; j < m; j++) { // TC: O(M)
            chars[txt.charAt(j) - 'a']--;
            if (j - i + 1 == n) {
                if (allZeros(chars)) { // TC: O(26)
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
    private boolean allZeros(int[] chars) {
        for (int c : chars) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
