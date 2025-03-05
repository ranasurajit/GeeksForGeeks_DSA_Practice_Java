//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * TC: O(N x log(N) + N x K)
     * SC: O(N x K)
     * where K = maximum length of any word in array 'words'
     */
    public int longestStringChain(String words[]) {
        Arrays.sort(words, (String a, String b) -> { // TC: O(N x log(N))
            return a.length() - b.length();
        });
        // Map to store the longest string chain possible for any word
        HashMap<String, Integer> map = new HashMap<String, Integer>(); // SC: 
        int maxLength = 1;
        for (String word : words) { // TC: O(N)
            int currentLength = 1;
            int k = word.length();
            for (int i = 0; i < k; i++) { // TC: O(K)
                StringBuilder sb = new StringBuilder(word); // SC: O(K)
                String predecessor = sb.deleteCharAt(i).toString();
                if (map.containsKey(predecessor)) {
                    currentLength = Math.max(currentLength, map.get(predecessor) + 1);
                }
            }
            map.put(word, currentLength);
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
