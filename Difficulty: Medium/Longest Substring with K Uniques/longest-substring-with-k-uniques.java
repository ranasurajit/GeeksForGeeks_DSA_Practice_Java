//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Took two pointers i and j = 0
     * 
     * Window size: (j - i + 1)
     * 
     * when HashMap size < k, j++
     * when HashMap size = k, compare and store the maximum window size (result),
     * j++
     * till HashMap size > k, then start removing elements from index 'i'
     * and update its count/remove key from HashMap, j++
     * 
     * TC: O(N)
     * SC: O(N)
     *
     * @param s
     * @param k
     * @return
     */
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        Map<Character, Integer> unique = new HashMap<Character, Integer>(); // SC: O(N)
        int maxLength = Integer.MIN_VALUE;
        while (j < n) { // TC: O(N)
            // add the character and it's count in HashMap 'unique'
            unique.put(s.charAt(j), unique.getOrDefault(s.charAt(j), 0) + 1);
            while (unique.size() > k) {
                // remove i index character from HashMap 'unique'
                unique.put(s.charAt(i), unique.getOrDefault(s.charAt(i), 0) - 1);
                if (unique.get(s.charAt(i)) == 0) {
                    /*
                     * character count has become zero after decreasing frequency
                     * so remove it from HashMap 'unique'
                     */
                    unique.remove(s.charAt(i));
                }
                // move i index to next to shrink the sliding window
                i++;
            }
            if (unique.size() == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }
}
