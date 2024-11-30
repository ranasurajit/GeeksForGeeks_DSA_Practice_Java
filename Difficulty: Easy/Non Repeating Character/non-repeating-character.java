//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    /**
     * TC: O(N)
     * SC: O(1)
     */
    static char nonRepeatingChar(String s) {
        int n = s.length();
        int[][] chars = new int[26][2];    // SC: O(52)
        for (int i = 0; i < n; i++) {      // TC: O(N)
            chars[s.charAt(i) - 'a'][0]++;
            chars[s.charAt(i) - 'a'][1] = i;
        }
        int minIndex = n;
        for (int i = 0; i < 26; i++) {      // TC: O(26)
            if (chars[i][0] == 1 && minIndex > chars[i][1]) {
                minIndex = chars[i][1];
            }
        }
        if (minIndex == n) {
            return '$';
        }
        return s.charAt(minIndex);
    }
}
