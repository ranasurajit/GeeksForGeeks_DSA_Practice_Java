//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

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
     * Using Sliding Window Technique (Variable Size)
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int longestUniqueSubstr(String s) {
        int n = s.length();
        int i = 0; // start index of sliding window
        int j = 0; // end index of sliding window
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(N)
        int maxLength = 0;
        while (j < n) { // TC: O(N)
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (j - i + 1 != map.size()) {
                // remove calculation of ith index
                int freq = map.get(s.charAt(i));
                if (freq > 1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                } else {
                    map.remove(s.charAt(i));
                }
                // shrink the window size
                i++;
            }
            if (j - i + 1 == map.size()) {
                // we have all distinct characters in the window
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength;
    }
}
