//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        long max = 0L;
        long temp = 0L;
        boolean isInValid = false;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch >= '0' && ch <= '9') {
                temp = temp * 10 + (ch - '0');
                if (ch == '9') {
                    isInValid = true;
                }
            } else if (ch == ' ') {
                if (!isInValid) {
                    max = Math.max(max, temp);
                }
                temp = 0;
                isInValid = false;
            }
        }
        if (!isInValid) {
            max = Math.max(max, temp);
        }
        return max == 0L ? -1 : max;
    }
}
