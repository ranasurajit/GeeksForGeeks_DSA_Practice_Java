//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    /**
     * TC: O(K)
     * SC: O(K), where K = number of dots
     */
    String reverseWords(String str) {
        String[] words = str.split("\\."); // SC: O(K)
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) { // TC: O(K)
            sb.append(words[i]);
            if (i > 0) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
