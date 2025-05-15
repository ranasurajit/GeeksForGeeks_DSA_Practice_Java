//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using Sliding Window (Variable Length) Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int longestUniqueSubstr(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(N)
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int maxLength = 0;
        while (j < n) { // TC: O(N)
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (j - i + 1 > map.size()) {
                // remove computation from ith index
                int freq = map.get(s.charAt(i));
                if (freq == 1) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), freq - 1);
                }
                // shrink the window
                i++;
            }
            if (j - i + 1 == map.size()) {
                // we got the desired window size
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength;
    }
}
