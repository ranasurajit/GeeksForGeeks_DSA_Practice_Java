//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if two strings are rotations of each other or not.
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public static boolean areRotations(String s1, String s2) {
        int n = s1.length();
        s2 = s2 + s2;
        int p = 0; // pointer for s1
        int q = 0; // pointer for s2
        while (p < n && q < 2 * n) { // TC: O(N)
            if (s1.charAt(p) != s2.charAt(q)) {
                q++;
            } else {
                p++;
                q++;
            }
        }
        if (p == n) {
            return true;
        }
        return false;
    }
}
