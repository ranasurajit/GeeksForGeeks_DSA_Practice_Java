//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using Math and Simulation Approach
     * 
     * TC: O(2 x R) ~ O(R)
     * SC: O(1)
     */
    public int nCr(int n, int r) {
        if (n < r) {
            return 0;
        }
        if (r == 0) {
            return 1;
        }
        long result = 1L;
        for (int i = 1; i <= r; i++) {
            result = result * (n - r + i);
            result = result / i;
        }
        return (int) result;
    }
}
