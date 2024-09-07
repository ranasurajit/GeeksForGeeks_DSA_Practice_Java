//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Here we need to convert n base 10 to base 9
     * 
     * TC: O(log(N) base 9)
     * SC: O(1)
     */
    long findNth(long n) {
        long base10 = n;
        long base9 = 0;
        long position = 1;
        while (base10 > 0) {
            long rem = base10 % 9;
            base9 += position * rem;
            base10 = base10 / 9;
            position = position * 10;
        }
        return base9;
    }
}
