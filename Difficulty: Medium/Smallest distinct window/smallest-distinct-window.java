//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int findSubString(String str) {
        int n = str.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        int k = map.size(); // number of distinct elements
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        map.clear();
        int minLength = n;
        while (j < n) { // TC: O(N)
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            while (map.size() == k) {
                minLength = Math.min(minLength, j - i + 1);
                // remove computation from index 'i'
                int freq = map.get(str.charAt(i));
                if (freq == 1) {
                    map.remove(str.charAt(i));
                } else {
                    map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                }
                i++;
            }
            j++;
        }
        return minLength;
    }
}
