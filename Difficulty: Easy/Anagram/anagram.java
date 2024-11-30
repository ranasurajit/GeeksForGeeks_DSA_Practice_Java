//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    /**
     * TC: O(M + N)
     * SC: O(1)
     */
    public static boolean areAnagrams(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] chars = new int[26];     // SC: O(26)
        for (int i = 0; i < m; i++) {  // TC: O(M)
            chars[s1.charAt(i) - 'a']++; 
        }
        for (int i = 0; i < n; i++) {  // TC: O(N)
            chars[s2.charAt(i) - 'a']--; 
        }
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
