//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /**
     * TC: O(2N) ~ O(N), where N is the length of String S
     * SC: O(1)
     */
    static int maxLength(String S){
        int n = S.length();
        int open = 0;
        int closed = 0;
        int maxL1 = 0; // max from left to right traversal
        int maxL2 = 0; // max from right to left traversal
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (S.charAt(i) == '(') {
                open++;
            } else {
                closed++;
            }
            if (closed > open) {
                open = 0;
                closed = 0;
            }
            if (closed == open) {
                maxL1 = Math.max(maxL1, 2 * open);
            }
        }
        // reseting open and closed to change the traversal direction
        open = 0;
        closed = 0;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            if (S.charAt(i) == '(') {
                open++;
            } else {
                closed++;
            }
            if (closed < open) {
                open = 0;
                closed = 0;
            }
            if (closed == open) {
                maxL2 = Math.max(maxL2, 2 * open);
            }
        }
        // get the maximum length of valid parentheses
        return Math.max(maxL1, maxL2);
    }
}
